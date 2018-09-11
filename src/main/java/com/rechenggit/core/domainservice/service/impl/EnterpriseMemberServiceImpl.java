package com.rechenggit.core.domainservice.service.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domainservice.repository.EnterpriseMemberDao;
import com.rechenggit.core.domainservice.service.EnterpriseMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EnterpriseMemberServiceImpl implements EnterpriseMemberService {

    @Autowired
    private EnterpriseMemberDao enterpriseMemberDao;

    @Override
    public BaseResponse saveEnterpriseServiceInfo(EnterpriseBasic enterpriseBasic) {
        return enterpriseMemberDao.saveEnterpriseServiceInfo(enterpriseBasic);
    }

    @Override
    public BaseResponse updateEnterpriseServiceInfo(EnterpriseBasic enterpriseBasic) {
        return enterpriseMemberDao.updateEnterpriseServiceInfo(enterpriseBasic);
    }

    @Override
    public EnterpriseBasic queryEnterpriseServiceInfo(String memberId) {
        return enterpriseMemberDao.queryEnterpriseServiceInfo(memberId);
    }

    @Override
    public BaseResponse deleteEnterpriseServiceInfo(String memberId) {
        return enterpriseMemberDao.deleteEnterpriseServiceInfo(memberId);
    }
}
