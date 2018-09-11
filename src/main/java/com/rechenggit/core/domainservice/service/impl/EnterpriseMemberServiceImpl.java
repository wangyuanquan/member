package com.rechenggit.core.domainservice.service.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import com.rechenggit.core.domainservice.mongodbrepository.MongoMemberRespository;
import com.rechenggit.core.domainservice.repository.EnterpriseMemberDao;
import com.rechenggit.core.domainservice.service.EnterpriseMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EnterpriseMemberServiceImpl implements EnterpriseMemberService {

    @Autowired
    private EnterpriseMemberDao enterpriseMemberDao;
    @Autowired
    private MongoMemberRespository mongoMemberRespository;
    @Override
    public BaseResponse saveEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        return enterpriseMemberDao.saveEnterpriseServiceInfo(enterpriseBasic);
    }

    @Override
    public BaseResponse updateEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        return enterpriseMemberDao.updateEnterpriseServiceInfo(enterpriseBasic);
    }

    @Override
    public EnterpriseBasic queryEnterpriseBasicInfo(String memberId) {
        return enterpriseMemberDao.queryEnterpriseServiceInfo(memberId);
    }

    @Override
    public BaseResponse deleteEnterpriseBasicInfo(String memberId) {
        return enterpriseMemberDao.deleteEnterpriseServiceInfo(memberId);
    }

    @Override
    public void saveEnterpriseServiceInfo(EnterpriseMemberServiceDomain enterpriseMemberServiceDomain) {
        mongoMemberRespository.insert(enterpriseMemberServiceDomain);
    }
}
