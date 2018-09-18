package com.rechenggit.core.domainservice.repository.impl;

import com.netfinworks.common.lang.StringUtil;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.*;
import com.rechenggit.core.dal.mapper.*;
import com.rechenggit.core.domain.enums.MemberTypeEnum;
import com.rechenggit.core.dal.mapper.EnterpriseBasicInfoMapper;
import com.rechenggit.core.dal.mapper.MemberIdentityMapper;
import com.rechenggit.core.dal.mapper.MemberMapper;
import com.rechenggit.core.dal.mapper.OperatorMapper;
import com.rechenggit.core.domain.login.EnterpriseServiceInfo;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;
import com.rechenggit.core.domain.login.ServicePasswordInfo;
import com.rechenggit.core.domainservice.repository.LoginRepository;
import com.rechenggit.core.domainservice.repository.SequenceRepository;
import com.rechenggit.util.FieldLength;
import com.rechenggit.util.MailUtil;
import com.rechenggit.util.Utils;
import com.rechenggit.web.LoginControl;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Repository
public class LoginRepositoryImpl implements LoginRepository {
    private final static Logger logger = LoggerFactory.getLogger(LoginControl.class);
    @Value("${email.url}")
    private String emailUrl  ;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberIdentityMapper memberIdentityMapper;
    @Autowired
    private EnterpriseBasicInfoMapper enterpriseBasicInfoMapper;
    @Autowired
    private OperatorMapper operatorMapper;
    @Autowired
    private SequenceRepository sequenceRepository;
    @Autowired
    private TrPasswordMapper trPasswordMapper;
    @Autowired
    private MailboxActivationMapper mailboxActivationMapper;
    @Autowired
    LoginNameMapper loginNameMapper;
    @Override
    public Member validateMemberExistAndNormal(String identity,int platformType) {
       /* //返回会员对象基本信息 （会员标识 平台类型）
        MemberIdentity identity = new Example(MemberIdentity.class);
        exampleMember.createCriteria()
                .andEqualTo("identity", request.getIdentity())
                 .andEqualTo("");
        List<Member> memberList = memberMapper.selectByExample(exampleMember);
        return memberList.get(0);*/
       return  null;
    }

    @Override
    public Operator getOperatorByPwd(String memberId , OperatorLoginPwdRequest request) {
        return null;
    }

    @Override
    public BaseResponse enterpriseService(EnterpriseServiceInfo serviceInfo) {
        //验证identity标识是否存在 tm_member_identity
        Example exampleMember = new Example(MemberIdentity.class);
        exampleMember.createCriteria().andEqualTo("identity", serviceInfo.getIdentity());
        List<MemberIdentity> memberIdentityList = memberIdentityMapper.selectByExample(exampleMember);
        if(!memberIdentityList.isEmpty()){
            return new BaseResponse(502,"该信息已存在，重复注册");
        }else{
            MemberTypeEnum memberType = MemberTypeEnum.getByCode(serviceInfo.getPid());
            String memberId = genMemberId(memberType);
            String operatorId = genOperatorId();
            //tm_member_identity 新增 member_id identity status(0：无效)
            Example exampleMemberIdentity = new Example(MemberIdentity .class);
            exampleMemberIdentity.createCriteria().andEqualTo("memberId", memberId);
            List<MemberIdentity> identityList = memberIdentityMapper.selectByExample(exampleMemberIdentity);
            MemberIdentity memberIdentity = new MemberIdentity();
            memberIdentity.setMemberId(memberId.toString());
            memberIdentity.setStatus(0);
            memberIdentity.setIdentity(serviceInfo.getIdentity());
            memberIdentity.setPid(serviceInfo.getPid());
            if(identityList.isEmpty()){
                memberIdentity.setCreateTime(new Date());
                memberIdentityMapper.insertSelective(memberIdentity);
            }else{
                memberIdentityMapper.updateByExampleSelective(memberIdentity,exampleMemberIdentity);
            }
            //tm_member 新增 member_id member_name status(0:未激活)
            Example exampleMember2 = new Example(Member .class);
            exampleMember2.createCriteria().andEqualTo("memberId", memberId);
            List<Member> memberList = memberMapper.selectByExample(exampleMember2);
            Member member = new Member();
            member.setMemberId(memberId.toString());
            member.setStatus(0);
            member.setMemberName(serviceInfo.getMemberName());
            if(memberList.isEmpty()){
                member.setCreateTime(new Date());
                memberMapper.insertSelective(member);
            }else{
                memberMapper.updateByExampleSelective(member,exampleMember2);
            }
            //tm_operator 新增 member_id status(0:未激活）
            Example exampleOperator = new Example(Operator.class);
            exampleOperator.createCriteria().andEqualTo("memberId", memberId);
            List<Operator> operatorList = operatorMapper.selectByExample(exampleOperator);
            Operator operator = new Operator();
            operator.setMemberId(memberId.toString());
            operator.setStatus(0);
            operator.setOperatorId(operatorId);
            operator.setOperatorType(memberType.getCode());
            if(operatorList.isEmpty()){
                operator.setCreateTime(new Date());
                operatorMapper.insertSelective(operator);
            }else{
                operatorMapper.updateByExampleSelective(operator,exampleOperator);
            }
            //tm_enterprise_basic_info 新增 member_id contact_name contact_phone email（identity）address
            Example exampleBasic = new Example(EnterpriseBasicInfo.class);
            exampleBasic.createCriteria().andEqualTo("memberId", memberId);
            List<EnterpriseBasicInfo> basicInfoList = enterpriseBasicInfoMapper.selectByExample(exampleBasic);
            EnterpriseBasicInfo basicInfo = new EnterpriseBasicInfo();
            basicInfo.setMemberId(memberId.toString());
            basicInfo.setContactName(serviceInfo.getContactName());
            basicInfo.setContactPhone(serviceInfo.getContactPhone());
            basicInfo.setMerEmail(serviceInfo.getIdentity());
            basicInfo.setMerAddress(serviceInfo.getAddress());
            if(basicInfoList.isEmpty()){
                basicInfo.setCreateTime(new Date());
                enterpriseBasicInfoMapper.insertSelective(basicInfo);
            }else{
                enterpriseBasicInfoMapper.updateByExampleSelective(basicInfo,exampleBasic);
            }
            BaseResponse baseResponse = new BaseResponse();
            ServicePasswordInfo servicePasswordInfo = new ServicePasswordInfo();
            servicePasswordInfo.setMemberId(memberId);
            servicePasswordInfo.setOperatorId(operatorId);
            baseResponse.setData(servicePasswordInfo);
            return baseResponse;
        }
    }

    @Override
    public BaseResponse saveServicePasswordInfo(ServicePasswordInfo servicePasswordInfo) {
        BaseResponse baseResponse = new BaseResponse();
        //验证identity标识是否存在 tm_member_identity （email）
        Example exampleMember = new Example(MemberIdentity.class);
        exampleMember.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<MemberIdentity> memberIdentityList = memberIdentityMapper.selectByExample(exampleMember);
        if(memberIdentityList.isEmpty()){
            return new BaseResponse(503,"保存密码失败，无相关注册信息");
        }
        //密码
        String loginPassword = Utils.hashSignContent(servicePasswordInfo.getLoginPassword());
        String paymentPassword = Utils.hashSignContent(servicePasswordInfo.getPaymentPassword());
        //tm_operator 更新 password
        Example exampleOperator = new Example(Operator.class);
        exampleOperator.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<Operator> operatorList = operatorMapper.selectByExample(exampleOperator);
        Operator operator = new Operator();
        operator.setPassword(loginPassword);
        if(operatorList.isEmpty()){
            operator.setCreateTime(new Date());
            operatorMapper.insertSelective(operator);
        }else{
            operatorMapper.updateByExampleSelective(operator,exampleOperator);
        }
        //tr_password 更新 password 交易密码
        Example examplePassword = new Example(TrPassword.class);
        examplePassword.createCriteria().andEqualTo("operatorId", servicePasswordInfo.getOperatorId());
        List<TrPassword> trPasswordList = trPasswordMapper.selectByExample(examplePassword);
        TrPassword trPassword = new TrPassword();
        trPassword.setPassword(paymentPassword);
        trPassword.setOperatorId(servicePasswordInfo.getOperatorId());
        if(trPasswordList.isEmpty()){
            trPassword.setCreateTime(new Date());
            trPasswordMapper.insertSelective(trPassword);
        }else{
            trPasswordMapper.updateByExampleSelective(trPassword,examplePassword);
        }

        //tm_mailbox_activation 新增 member_id mailbox_name activation_code status
        Example exampleMailboxActivation = new Example(MailboxActivation .class);
        exampleMailboxActivation.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<MailboxActivation> mailboxActivationList = mailboxActivationMapper.selectByExample(exampleMailboxActivation);
        MailboxActivation mailboxActivation = new MailboxActivation();
        mailboxActivation.setStatus(0);
        mailboxActivation.setMemberId(servicePasswordInfo.getMemberId());
        String email = memberIdentityList.get(0).getIdentity();
        mailboxActivation.setMailboxName(email);
        String code= UUID.randomUUID().toString().replaceAll("-", "");
        mailboxActivation.setActivationCode(code);
        new Thread(new MailUtil(email,code,emailUrl)).start();
        if(mailboxActivationList.isEmpty()){
            mailboxActivation.setCreateTime(new Date());
            mailboxActivationMapper.insertSelective(mailboxActivation);
        }else{
            mailboxActivationMapper.updateByExampleSelective(mailboxActivation,exampleMailboxActivation);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse verifyingMailbox(String email,String code) {
        BaseResponse baseResponse = new BaseResponse();
        Example exampleMailboxActivation = new Example(MailboxActivation .class);
        exampleMailboxActivation.createCriteria().andEqualTo("activationCode", code)
                .andEqualTo("mailboxName", email);
        List<MailboxActivation> mailboxActivationList = mailboxActivationMapper.selectByExample(exampleMailboxActivation);
        if(mailboxActivationList.isEmpty()){
            return new BaseResponse(501,"没有相关信息，激活失败");
        }
        MailboxActivation mailboxActivation = new MailboxActivation();
        mailboxActivation.setStatus(1);
        mailboxActivationMapper.updateByExampleSelective(mailboxActivation,exampleMailboxActivation);
        String memberId = mailboxActivationList.get(0).getMemberId();
        //tm_member_identity 激活
        Example exampleMemberIdentity = new Example(MemberIdentity .class);
        exampleMemberIdentity.createCriteria().andEqualTo("memberId", memberId);
        List<MemberIdentity> identityList = memberIdentityMapper.selectByExample(exampleMemberIdentity);
        MemberIdentity memberIdentity = new MemberIdentity();
        memberIdentity.setStatus(1);
        if(identityList.isEmpty()){
            return new BaseResponse(501,"平台信息（MemberIdentity）未注册，激活失败");
        }else{
            memberIdentityMapper.updateByExampleSelective(memberIdentity,exampleMemberIdentity);
        }
        //tm_member 激活
        Example exampleMember2 = new Example(Member .class);
        exampleMember2.createCriteria().andEqualTo("memberId", memberId);
        List<Member> memberList = memberMapper.selectByExample(exampleMember2);
        Member member = new Member();
        member.setStatus(1);
        if(memberList.isEmpty()){
            return new BaseResponse(501,"平台信息（Member）未注册，激活失败");
        }else{
            memberMapper.updateByExampleSelective(member,exampleMember2);
        }
        //添加 tr_login_name
        Example exampleLoginName = new Example(LoginName .class);
        exampleLoginName.createCriteria().andEqualTo("memberId", memberId);
        List<LoginName> loginNameList = loginNameMapper.selectByExample(exampleLoginName);
        //Operator
        Example exampleOperator = new Example(Operator.class);
        exampleOperator.createCriteria().andEqualTo("memberId", memberId);
        List<Operator> operatorList = operatorMapper.selectByExample(exampleOperator);
        LoginName loginName = new LoginName();
        if(operatorList.isEmpty() || memberList.isEmpty() || identityList.isEmpty()){
            return new BaseResponse(501,"注册信息不全，激活失败");
        }else{
            loginName.setOperatorId(operatorList.get(0).getOperatorId());
            loginName.setMemberId(operatorList.get(0).getMemberId());
            loginName.setLoginName(memberList.get(0).getMemberName());
            loginName.setSourceType(identityList.get(0).getPid());
            loginName.setLoginNameType(operatorList.get(0).getOperatorType());
        }
        if(loginNameList.isEmpty()){
            loginName.setCreateTime(new Date());
            loginNameMapper.insertSelective(loginName);
        }else{
            loginNameMapper.updateByExampleSelective(loginName,exampleLoginName);
        }
        return baseResponse;
    }

    /*
     * 生成操作员id
     */
    private String genOperatorId() {
        String prefix = MaConstant.PRE_OPERATOR_ID;
        int seqLen = FieldLength.OPERATOR_ID - prefix.length();
        String operatorId = prefix
                + StringUtil.alignRight(
                String.valueOf(sequenceRepository.next(MaConstant.SEQ_OPERATOR_ID)), seqLen,
                MaConstant.ID_FIX_CHAR);
        return operatorId;
    }
    /*
     * 生成memberId
     */
    public String genMemberId(MemberTypeEnum memberType) {
        String pre = null;
        String seq = String.valueOf(sequenceRepository.next(MaConstant.SEQ_MEMBER_ID));
        if (memberType == MemberTypeEnum.COMPANY) {
            pre = MaConstant.PRE_MEMBER_COMPANY_ID;
        } else if (memberType == MemberTypeEnum.PERSONAL) {
            pre = MaConstant.PRE_MEMBER_PERSONAL_ID;
        } else {
            pre = MaConstant.PRE_MEMBER_INSTITUTION_ID;
        }
        String memberId = pre
                + StringUtil.alignRight(seq, MaConstant.MEMBER_ID_SEQ_LENGTH,
                MaConstant.ID_FIX_CHAR);
        return memberId;
    }
    /*
     * 生成密码
     */

    //解密
    public static String decryPwd(String param)
    {
        String pwd= StringUtils.substring(param,64);
        return pwd;
    }


}
