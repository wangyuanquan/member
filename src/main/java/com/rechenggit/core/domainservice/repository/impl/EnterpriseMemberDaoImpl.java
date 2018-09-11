package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.CompanyInfo;
import com.rechenggit.core.dal.dataobject.EnterpriseBasicInfo;
import com.rechenggit.core.dal.dataobject.StoreInfo;
import com.rechenggit.core.dal.mapper.CompanyInfoMapper;
import com.rechenggit.core.dal.mapper.EnterpriseBasicInfoMapper;
import com.rechenggit.core.dal.mapper.StoreInfoMapper;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domainservice.repository.EnterpriseMemberDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EnterpriseMemberDaoImpl implements EnterpriseMemberDao {

    @Autowired
    private EnterpriseBasicInfoMapper enterpriseBasicInfoMapper;
    @Autowired
    private StoreInfoMapper storeInfoMapper;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    @Override
    public BaseResponse saveEnterpriseServiceInfo(EnterpriseBasic enterpriseBasic) {
        EnterpriseBasicInfo basicInfo = new EnterpriseBasicInfo();
        BeanUtils.copyProperties(enterpriseBasic,basicInfo);
        //新增基本信息
        enterpriseBasicInfoMapper.insert(basicInfo);
        int StoreSize = enterpriseBasic.getStoreInfo().size();
        for (int i=0;i<StoreSize;i++){
            StoreInfo storeInfo = new StoreInfo();
            BeanUtils.copyProperties(enterpriseBasic.getStoreInfo().get(i),storeInfo);
            storeInfoMapper.insert(storeInfo);
        }
        int Companysize = enterpriseBasic.getCompanyInfo().size();
        for (int i=0;i<Companysize;i++){
            CompanyInfo companyInfo = new CompanyInfo();
            BeanUtils.copyProperties(enterpriseBasic.getCompanyInfo().get(i),companyInfo);
            companyInfoMapper.insert(companyInfo);
        }
        return new BaseResponse();
    }

    @Override
    public BaseResponse updateEnterpriseServiceInfo(EnterpriseBasic enterpriseBasic) {
        return null;
    }

    @Override
    public EnterpriseBasic queryEnterpriseServiceInfo(String memberId) {

        return null;
    }

    @Override
    public BaseResponse deleteEnterpriseServiceInfo(String memberId) {
        return null;
    }
}
