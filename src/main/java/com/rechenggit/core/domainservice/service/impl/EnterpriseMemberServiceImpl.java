package com.rechenggit.core.domainservice.service.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domainservice.repository.EnterpriseMemberRepository;
import com.rechenggit.core.domainservice.service.EnterpriseMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EnterpriseMemberServiceImpl implements EnterpriseMemberService {

    @Autowired
    private EnterpriseMemberRepository enterpriseMemberDao;

    @Override
    public BaseResponse saveEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        return enterpriseMemberDao.saveEnterpriseBasicInfo(enterpriseBasic);
    }

    @Override
    public BaseResponse updateEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        return enterpriseMemberDao.updateEnterpriseBasicInfo(enterpriseBasic);
    }

    @Override
    public EnterpriseBasic queryEnterpriseBasicInfo(String memberId) {
        return enterpriseMemberDao.queryEnterpriseBasicInfo(memberId);
    }

    @Override
    public BaseResponse deleteEnterpriseBasicInfo(String memberId) {
        return enterpriseMemberDao.deleteEnterpriseBasicInfo(memberId);
    }
}
