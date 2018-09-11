package com.rechenggit.core.domainservice.service.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import com.rechenggit.core.domainservice.mongodbrepository.MongoMemberRespository;
import com.rechenggit.core.domainservice.repository.EnterpriseMemberRepository;
import com.rechenggit.core.domainservice.service.EnterpriseMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EnterpriseMemberServiceImpl implements EnterpriseMemberService {

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
    public EnterpriseBasic queryEnterpriseBasicInfo(String memberId) {
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
}
