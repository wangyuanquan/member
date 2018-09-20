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
import com.rechenggit.core.exception.CommonDefinedException;
import com.rechenggit.core.exception.ErrorCodeException;
import com.rechenggit.core.exception.ErrorCodeException.CommonException;
import com.rechenggit.util.FieldLength;
import com.rechenggit.util.MaiSendUtil;
import com.rechenggit.util.Utils;
import com.rechenggit.web.LoginControl;
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
    public ServicePasswordInfo enterpriseService(EnterpriseServiceInfo serviceInfo) throws CommonException{
        //验证identity标识是否存在 tm_member_identity
        Example exampleIdentity = new Example(MemberIdentity.class);
        exampleIdentity.createCriteria().andEqualTo("identity", serviceInfo.getIdentity());
        List<MemberIdentity> memberIdentityList = memberIdentityMapper.selectByExample(exampleIdentity);
        if(!memberIdentityList.isEmpty()){
            CommonException exp = CommonDefinedException.SERVICE_REPEAT;
            exp.setMemo(serviceInfo.getIdentity());
            throw exp;
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
            Example exampleMember = new Example(Member .class);
            exampleMember.createCriteria().andEqualTo("memberId", memberId);
            List<Member> memberList = memberMapper.selectByExample(exampleMember);
            Member member = new Member();
            member.setMemberId(memberId.toString());
            member.setStatus(0);
            member.setMemberName(serviceInfo.getMemberName());
            if(memberList.isEmpty()){
                member.setCreateTime(new Date());
                memberMapper.insertSelective(member);
            }else{
                memberMapper.updateByExampleSelective(member,exampleMember);
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
            ServicePasswordInfo servicePasswordInfo = new ServicePasswordInfo();
            servicePasswordInfo.setMemberId(memberId);
            servicePasswordInfo.setOperatorId(operatorId);
            return servicePasswordInfo;
        }
    }
    //已优化 不调用该方法
    @Override
    public BaseResponse saveServicePasswordInfo(ServicePasswordInfo servicePasswordInfo) {
        BaseResponse baseResponse = new BaseResponse();
        //验证identity标识是否存在 tm_member_identity （email）
        Example exampleMember = new Example(MemberIdentity.class);
        exampleMember.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<MemberIdentity> memberIdentityList = memberIdentityMapper.selectByExample(exampleMember);
        if(memberIdentityList.isEmpty()){
            return new BaseResponse(503,"service.nothing.information");
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
        String code= UUID.randomUUID().toString().replaceAll("-", "");
        Example exampleMailboxActivation = new Example(MailboxActivation .class);
        exampleMailboxActivation.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId())
                .andEqualTo("activationCode", code);
        List<MailboxActivation> mailboxActivationList = mailboxActivationMapper.selectByExample(exampleMailboxActivation);
        MailboxActivation mailboxActivation = new MailboxActivation();
        mailboxActivation.setStatus(0);
        mailboxActivation.setMemberId(servicePasswordInfo.getMemberId());
        String email = memberIdentityList.get(0).getIdentity();
        mailboxActivation.setMailboxName(email);
        mailboxActivation.setActivationCode(code);
        MaiSendUtil.verifyingMailbox(email,code,emailUrl);
        if(mailboxActivationList.isEmpty()){
            mailboxActivation.setCreateTime(new Date());
            mailboxActivationMapper.insertSelective(mailboxActivation);
        }else{
            mailboxActivationMapper.updateByExampleSelective(mailboxActivation,exampleMailboxActivation);
        }
        return baseResponse;
    }
    //登录密码
    @Override
    public int saveLoginPassword(ServicePasswordInfo servicePasswordInfo) throws CommonException {
        //验证Operator中的memberId operatorId是否跟参数一致
        Example exampleOperator = new Example(Operator.class);
        exampleOperator.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<Operator> operatorList = operatorMapper.selectByExample(exampleOperator);
        if(operatorList.isEmpty()){
            CommonException exp = CommonDefinedException.ACTIVATION_UNREGISTERED_OPERATOR;
            exp.setMemo(servicePasswordInfo.getMemberId());
            throw exp;
        }
        String operatorId = operatorList.get(0).getOperatorId();
        if(!operatorId.equals(servicePasswordInfo.getOperatorId())){
            CommonException exp = CommonDefinedException.ACTIVATION_DIFFERENCE;
            exp.setMemo("参数operatorId："+servicePasswordInfo.getOperatorId()+"查询operatorId："+operatorId);
            throw exp;
        }
        //登录密码
        String loginPassword = Utils.hashSignContent(servicePasswordInfo.getLoginPassword());
        //tm_operator 更新 password
        Operator operator = new Operator();
        operator.setPassword(loginPassword);
        int result = 0;
        if(operatorList.isEmpty()){
            operator.setCreateTime(new Date());
            result = operatorMapper.insertSelective(operator);
        }else{
            result = operatorMapper.updateByExampleSelective(operator,exampleOperator);
        }
        return result;
    }

    @Override
    public Boolean checkLoginPassword(String memberId, String password) {
        //获取Operator中的password
        Example exampleOperator = new Example(Operator.class);
        exampleOperator.createCriteria().andEqualTo("memberId", memberId);
        List<Operator> operatorList = operatorMapper.selectByExample(exampleOperator);
        if(operatorList.isEmpty()){
            return false;
        }
        return operatorList.get(0).getPassword().equals(Utils.hashSignContent(password));
    }

    @Override
    public Boolean checkTransactionPassword(String operatorId, String password) {
        //tr_password 获取 password 交易密码
        Example examplePassword = new Example(TrPassword.class);
        examplePassword.createCriteria().andEqualTo("operatorId", operatorId);
        List<TrPassword> trPasswordList = trPasswordMapper.selectByExample(examplePassword);
        if(trPasswordList.isEmpty()){
            return false;
        }
        return trPasswordList.get(0).getPassword().equals(Utils.hashSignContent(password));
    }

    //交易密码
    @Override
    public int saveTransactionPassword(ServicePasswordInfo servicePasswordInfo) throws CommonException {
        //验证Operator中的memberId operatorId是否跟参数一致
        Example exampleOperator = new Example(Operator.class);
        exampleOperator.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<Operator> operatorList = operatorMapper.selectByExample(exampleOperator);
        if(operatorList.isEmpty()){
            CommonException exp = CommonDefinedException.ACTIVATION_UNREGISTERED_OPERATOR;
            exp.setMemo(servicePasswordInfo.getMemberId());
            throw exp;
        }
        String operatorId = operatorList.get(0).getOperatorId();
        if(!operatorId.equals(servicePasswordInfo.getOperatorId())){
            CommonException exp = CommonDefinedException.ACTIVATION_DIFFERENCE;
            exp.setMemo("参数operatorId："+servicePasswordInfo.getOperatorId()+"查询operatorId："+operatorId);
            throw exp;
        }
        //tr_password 更新 password 交易密码
        String paymentPassword = Utils.hashSignContent(servicePasswordInfo.getPaymentPassword());
        Example examplePassword = new Example(TrPassword.class);
        examplePassword.createCriteria().andEqualTo("operatorId", servicePasswordInfo.getOperatorId());
        List<TrPassword> trPasswordList = trPasswordMapper.selectByExample(examplePassword);
        TrPassword trPassword = new TrPassword();
        trPassword.setPassword(paymentPassword);
        trPassword.setOperatorId(servicePasswordInfo.getOperatorId());
        int result = 0;
        if(trPasswordList.isEmpty()){
            trPassword.setCreateTime(new Date());
            result = trPasswordMapper.insertSelective(trPassword);
        }else{
            result = trPasswordMapper.updateByExampleSelective(trPassword,examplePassword);
        }
        return result;
    }
    //发送激活邮件
    @Override
    public int sendActivationMail(ServicePasswordInfo servicePasswordInfo) throws CommonException{
        //获取identity标识 tm_member_identity （email）
        Example exampleMember = new Example(MemberIdentity.class);
        exampleMember.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<MemberIdentity> memberIdentityList = memberIdentityMapper.selectByExample(exampleMember);
        if(memberIdentityList.isEmpty()){
            CommonException exp = CommonDefinedException.ACTIVATION_UNREGISTERED_IDENTITY;
            exp.setMemo(servicePasswordInfo.getMemberId());
            throw exp;
        }
        String email = memberIdentityList.get(0).getIdentity();
        //tm_mailbox_activation 新增 member_id mailbox_name activation_code status
        String code= UUID.randomUUID().toString().replaceAll("-", "");
        Example exampleMailboxActivation = new Example(MailboxActivation .class);
        exampleMailboxActivation.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId())
                .andEqualTo("activationCode", code);
        List<MailboxActivation> mailboxActivationList = mailboxActivationMapper.selectByExample(exampleMailboxActivation);
        MailboxActivation mailboxActivation = new MailboxActivation();
        mailboxActivation.setStatus(0);
        mailboxActivation.setMemberId(servicePasswordInfo.getMemberId());
        mailboxActivation.setMailboxName(email);
        mailboxActivation.setActivationCode(code);
        MaiSendUtil.verifyingMailbox(email,code,emailUrl);
        int result = 0;
        if(mailboxActivationList.isEmpty()){
            mailboxActivation.setCreateTime(new Date());
            result = mailboxActivationMapper.insertSelective(mailboxActivation);
        }else{
            result = mailboxActivationMapper.updateByExampleSelective(mailboxActivation,exampleMailboxActivation);
        }
        return result;
    }

    @Override
    public BaseResponse verifyingMailbox(String email,String code) throws CommonException{
        BaseResponse baseResponse = new BaseResponse();
        Example exampleMailboxActivation = new Example(MailboxActivation .class);
        exampleMailboxActivation.createCriteria().andEqualTo("activationCode", code)
                .andEqualTo("mailboxName", email);
        List<MailboxActivation> mailboxActivationList = mailboxActivationMapper.selectByExample(exampleMailboxActivation);
        if(mailboxActivationList.isEmpty()){
            CommonException exp = CommonDefinedException.SERVICE_REPEAT;
            exp.setMemo("邮箱"+email+"激活码"+code);
            throw exp;
        }
        MailboxActivation mailboxActivation = new MailboxActivation();
        if(mailboxActivationList.get(0).getStatus() == 1){
            CommonException exp = CommonDefinedException.ACTIVATION_REPEAT;
            exp.setMemo("邮箱"+email+"激活码"+code);
            throw exp;
        }
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
            CommonException exp = CommonDefinedException.ACTIVATION_UNREGISTERED_IDENTITY;
            exp.setMemo("memberId"+memberId);
            throw exp;
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
            CommonException exp = CommonDefinedException.ACTIVATION_UNREGISTERED_MEMBER;
            exp.setMemo("memberId"+memberId);
            throw exp;
        }else{
            memberMapper.updateByExampleSelective(member,exampleMember2);
        }
        //tm_Operator 激活
        Example exampleOperator = new Example(Operator .class);
        exampleOperator.createCriteria().andEqualTo("memberId", memberId);
        List<Operator> operatorList = operatorMapper.selectByExample(exampleOperator);
        Operator operator = new Operator();
        operator.setStatus(1);
        if(operatorList.isEmpty()){
            CommonException exp = CommonDefinedException.ACTIVATION_UNREGISTERED_OPERATOR;
            exp.setMemo("memberId"+memberId);
            throw exp;
        }else{
            operatorMapper.updateByExampleSelective(operator,exampleOperator);
        }
        //添加 tr_login_name
        Example exampleLoginName = new Example(LoginName .class);
        exampleLoginName.createCriteria().andEqualTo("memberId", memberId);
        List<LoginName> loginNameList = loginNameMapper.selectByExample(exampleLoginName);
        LoginName loginName = new LoginName();
        if(operatorList.isEmpty() || memberList.isEmpty() || identityList.isEmpty()){
            CommonException exp = CommonDefinedException.ACTIVATION_UNREGISTERED_LOGINNAME;
            exp.setMemo("memberId"+memberId);
            throw exp;
        }else{
            loginName.setOperatorId(operatorList.get(0).getOperatorId());
            loginName.setMemberId(operatorList.get(0).getMemberId());
            loginName.setLoginName("admin");
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

    @Override
    public BaseResponse findLoginPassword(String email)  throws CommonException{
        BaseResponse baseResponse = new BaseResponse();
        //验证identity标识是否存在 tm_member_identity
        Example exampleIdentity = new Example(MemberIdentity.class);
        exampleIdentity.createCriteria().andEqualTo("identity", email);
        List<MemberIdentity> memberIdentityList = memberIdentityMapper.selectByExample(exampleIdentity);
        if(!memberIdentityList.isEmpty()){
            CommonException exp = CommonDefinedException.REQUEST_PARAMETER;
            exp.setMemo("identity"+email);
            throw exp;
        }else {
            //tm_mailbox_activation 新增 member_id mailbox_name activation_code status
            String code = UUID.randomUUID().toString().replaceAll("-", "");
            Example exampleMailboxActivation = new Example(MailboxActivation.class);
            exampleMailboxActivation.createCriteria().andEqualTo("memberId", memberIdentityList.get(0).getMemberId())
                    .andEqualTo("activationCode", code);
            List<MailboxActivation> mailboxActivationList = mailboxActivationMapper.selectByExample(exampleMailboxActivation);
            MailboxActivation mailboxActivation = new MailboxActivation();
            mailboxActivation.setStatus(0);
            mailboxActivation.setMemberId(memberIdentityList.get(0).getMemberId());
            mailboxActivation.setMailboxName(email);
            mailboxActivation.setActivationCode(code);
            MaiSendUtil.findLoginPassword(email, code, emailUrl);
            if (mailboxActivationList.isEmpty()) {
                mailboxActivation.setCreateTime(new Date());
                mailboxActivationMapper.insertSelective(mailboxActivation);
            } else {
                mailboxActivationMapper.updateByExampleSelective(mailboxActivation, exampleMailboxActivation);
            }
        }
        return baseResponse;
    }

    /*
     * 生成操作员id
     */
    public String genOperatorId() {
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


}
