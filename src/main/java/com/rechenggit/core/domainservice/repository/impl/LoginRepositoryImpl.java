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
import com.rechenggit.web.LoginControl;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import sun.security.util.Password;
import tk.mybatis.mapper.entity.Example;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
@Service
@Repository
public class LoginRepositoryImpl implements LoginRepository {
    private final static Logger logger = LoggerFactory.getLogger(LoginControl.class);
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
            return baseResponse;
        }
    }

    @Override
    public BaseResponse saveServicePasswordInfo(ServicePasswordInfo servicePasswordInfo) {
        BaseResponse baseResponse = new BaseResponse();
        //密码
        String loginPassword = hashSignContent(servicePasswordInfo.getLoginPassword());
        String paymentPassword = hashSignContent(servicePasswordInfo.getPaymentPassword());
        //tm_operator 更新 password
        Example exampleOperator = new Example(Operator.class);
        exampleOperator.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<Operator> operatorList = operatorMapper.selectByExample(exampleOperator);
        Operator operator = new Operator();
        operator.setPassword(loginPassword);
        operator.setStatus(1);
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
        if(trPasswordList.isEmpty()){
            trPassword.setCreateTime(new Date());
            trPasswordMapper.insertSelective(trPassword);
        }else{
            trPasswordMapper.updateByExampleSelective(trPassword,examplePassword);
        }
        //tm_member_identity 激活
        Example exampleMemberIdentity = new Example(MemberIdentity .class);
        exampleMemberIdentity.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<MemberIdentity> identityList = memberIdentityMapper.selectByExample(exampleMemberIdentity);
        MemberIdentity memberIdentity = new MemberIdentity();
        memberIdentity.setStatus(1);
        if(identityList.isEmpty()){
            memberIdentity.setCreateTime(new Date());
            memberIdentityMapper.insertSelective(memberIdentity);
        }else{
            memberIdentityMapper.updateByExampleSelective(memberIdentity,exampleMemberIdentity);
        }
        //tm_member 激活
        Example exampleMember2 = new Example(Member .class);
        exampleMember2.createCriteria().andEqualTo("memberId", servicePasswordInfo.getMemberId());
        List<Member> memberList = memberMapper.selectByExample(exampleMember2);
        Member member = new Member();
        member.setStatus(1);
        if(memberList.isEmpty()){
            member.setCreateTime(new Date());
            memberMapper.insertSelective(member);
        }else{
            memberMapper.updateByExampleSelective(member,exampleMember2);
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
    public static String hashSignContent(String txt) {
        try {
            return DigestUtils.sha256Hex(txt.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException var2) {
            logger.error(var2.getMessage(), var2);
            return null;
        }
    }
}
