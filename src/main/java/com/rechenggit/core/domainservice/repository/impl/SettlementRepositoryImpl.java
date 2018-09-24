package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.EnterpriseBasicInfo;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.MemberIdentity;
import com.rechenggit.core.dal.dataobject.SettlementsInfo;
import com.rechenggit.core.dal.mapper.EnterpriseBasicInfoMapper;
import com.rechenggit.core.dal.mapper.MemberIdentityMapper;
import com.rechenggit.core.dal.mapper.MemberMapper;
import com.rechenggit.core.dal.mapper.SettlementsInfoMapper;
import com.rechenggit.core.domain.enums.ResponseCode;
import com.rechenggit.core.domain.settlements.EnterpriseSettlementInfo;
import com.rechenggit.core.domainservice.repository.SettlementRepository;
import com.rechenggit.core.exception.MaBizException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Repository
public class SettlementRepositoryImpl implements SettlementRepository {
    @Autowired
    SettlementsInfoMapper settlementsInfoMapper;
    @Autowired
    private EnterpriseBasicInfoMapper enterpriseBasicInfoMapper;
    @Autowired
    private MemberIdentityMapper memberIdentityMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public int saveRateInfo(EnterpriseSettlementInfo enterpriseSettlementInfo) throws MaBizException{
        //获取tm_member_identity  memberId验证参数
        Example exampleMember = new Example(MemberIdentity.class);
        exampleMember.createCriteria().andEqualTo("memberId", enterpriseSettlementInfo.getMemberId());
        List<MemberIdentity> memberIdentityList = memberIdentityMapper.selectByExample(exampleMember);
        if(memberIdentityList.isEmpty()){
            throw new MaBizException(ResponseCode.ARGUMENT_ERROR,
                    "tm_member_identity表中memberId" + enterpriseSettlementInfo.getMemberId() + "的相关信息不存在");
        }
        //tm_settlements_info 保存 汇率信息
        Example exampleSettlementsInfo = new Example(SettlementsInfo.class);
        exampleSettlementsInfo.createCriteria().andEqualTo("memberId", enterpriseSettlementInfo.getMemberId());
        List<SettlementsInfo> settlementInfoList = settlementsInfoMapper.selectByExample(exampleSettlementsInfo);
        SettlementsInfo settlementsInfo = new SettlementsInfo();
        BeanUtils.copyProperties(enterpriseSettlementInfo,settlementsInfo);
        int result;
        if(settlementInfoList.isEmpty()){
            settlementsInfo.setCreateTime(new Date());
            result = settlementsInfoMapper.insertSelective(settlementsInfo);
        }else{
            result = settlementsInfoMapper.updateByExampleSelective(settlementsInfo,exampleSettlementsInfo);
        }
        return result;
    }

    @Override
    public EnterpriseSettlementInfo queryRateInfo(String memberId) throws MaBizException {
        //tm_settlements_info  汇率信息
        Example exampleSettlementsInfo = new Example(SettlementsInfo.class);
        exampleSettlementsInfo.createCriteria().andEqualTo("memberId", memberId);
        List<SettlementsInfo> settlementInfoList = settlementsInfoMapper.selectByExample(exampleSettlementsInfo);
        EnterpriseSettlementInfo enterpriseSettlementInfo = new EnterpriseSettlementInfo();
        if(settlementInfoList.isEmpty()){
            throw new MaBizException(ResponseCode.ARGUMENT_ERROR,
                    "tm_settlements_info表中memberId" + memberId + "的相关信息不存在");
        }else{
            BeanUtils.copyProperties(settlementInfoList.get(0),enterpriseSettlementInfo);
        }
        //tm_enterprise_basic_info 基本信息
        Example exampleBasicInfo = new Example(EnterpriseBasicInfo.class);
        exampleBasicInfo.createCriteria().andEqualTo("memberId", memberId);
        List<EnterpriseBasicInfo> basicInfoList = enterpriseBasicInfoMapper.selectByExample(exampleBasicInfo);
        if(basicInfoList.isEmpty()){
            throw new MaBizException(ResponseCode.ARGUMENT_ERROR,
                    "tm_enterprise_basic_info表中memberId" + memberId + "的相关信息不存在");
        }else{
            BeanUtils.copyProperties(basicInfoList.get(0),enterpriseSettlementInfo);
        }
        //商家名称 tm_member
        Example exampleMember = new Example(Member.class);
        exampleMember.createCriteria().andEqualTo("memberId", memberId);
        List<Member> memberList = memberMapper.selectByExample(exampleMember);
        if(memberList.isEmpty()){
            throw new MaBizException(ResponseCode.ARGUMENT_ERROR,
                    "tm_member表中memberId" + memberId + "的相关信息不存在");
        }
        enterpriseSettlementInfo.setMemberName(memberList.get(0).getMemberName());
        return enterpriseSettlementInfo;
    }
}
