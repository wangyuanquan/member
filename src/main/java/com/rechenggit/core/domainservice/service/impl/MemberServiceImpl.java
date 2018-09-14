package com.rechenggit.core.domainservice.service.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import com.rechenggit.core.domain.EnterpriseOther;
import com.rechenggit.core.domainservice.mongodbrepository.MongoMemberRespository;
import com.rechenggit.core.domainservice.repository.EnterpriseMemberRepository;
import com.rechenggit.core.domainservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private EnterpriseMemberRepository enterpriseMemberRepository;
    @Autowired
    private MongoMemberRespository mongoMemberRespository;
    @Override
    public BaseResponse saveEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        return enterpriseMemberRepository.saveEnterpriseBasicInfo(enterpriseBasic);
    }

    @Override
    public BaseResponse updateEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        return enterpriseMemberRepository.updateEnterpriseBasicInfo(enterpriseBasic);
    }

    @Override
    public BaseResponse queryEnterpriseBasicInfo(String memberId) {
        return enterpriseMemberRepository.queryEnterpriseBasicInfo(memberId);
    }

    @Override
    public BaseResponse deleteEnterpriseBasicInfo(String memberId) {
        return enterpriseMemberRepository.deleteEnterpriseBasicInfo(memberId);
    }

    @Override
    public void saveEnterpriseServiceInfo(EnterpriseMemberServiceDomain enterpriseMemberServiceDomain) {
        mongoMemberRespository.insert(enterpriseMemberServiceDomain);
    }

    @Override
    public EnterpriseMemberServiceDomain queryEnterpriseServiceInfoById(String memberId) {
        return mongoMemberRespository.findOne(memberId);
    }

    @Override
    public BaseResponse saveEnterpriseOtherInfo(EnterpriseOther enterpriseOther) {
        return enterpriseMemberRepository.saveEnterpriseOtherInfo(enterpriseOther);
    }

    @Override
    public BaseResponse queryEnterpriseOtherInfo(String memberId) {
        return enterpriseMemberRepository.queryEnterpriseOtherInfo(memberId);
    }

    @Override
    public BaseResponse deleteEnterpriseOtherInfo(String memberId) {
        return enterpriseMemberRepository.deleteEnterpriseOtherInfo(memberId);
    }
}
