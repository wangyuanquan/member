package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.CompanyInfo;
import com.rechenggit.core.dal.dataobject.EnterpriseBasicInfo;
import com.rechenggit.core.dal.dataobject.StoreInfo;
import com.rechenggit.core.dal.mapper.CompanyInfoMapper;
import com.rechenggit.core.dal.mapper.EnterpriseBasicInfoMapper;
import com.rechenggit.core.dal.mapper.StoreInfoMapper;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseStore;
import com.rechenggit.core.domainservice.repository.EnterpriseMemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


@Repository
public class EnterpriseMemberRepositoryImpl implements EnterpriseMemberRepository {

    @Autowired
    private EnterpriseBasicInfoMapper enterpriseBasicInfoMapper;
    @Autowired
    private StoreInfoMapper storeInfoMapper;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    @Override
    public BaseResponse saveEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        String memberId = enterpriseBasic.getMemberId();
        if(memberId == null || "".equals(memberId) ){
            return new BaseResponse(501,"没有商户ID，添加相关信息失败");
        }
        Example exampleBasic = new Example(EnterpriseBasicInfo.class);
        exampleBasic.createCriteria().andEqualTo("memberId", memberId);
        List<EnterpriseBasicInfo> basicInfoList = enterpriseBasicInfoMapper.selectByExample(exampleBasic);
        if(!basicInfoList.isEmpty()){
            return new BaseResponse(502,"该商户信息已添加");
        }
        EnterpriseBasicInfo basicInfo = new EnterpriseBasicInfo();
        BeanUtils.copyProperties(enterpriseBasic,basicInfo);
        //新增基本信息
        basicInfo.setCreateTime(new Date());
        enterpriseBasicInfoMapper.insertSelective(basicInfo);
        //新增商店信息
        int StoreSize = enterpriseBasic.getStoreInfo().size();
        for (int i=0;i<StoreSize;i++){
            Example exampleStore = new Example(StoreInfo.class);
            exampleStore.createCriteria().andEqualTo("memberId", memberId).andEqualTo("displayNum",
                    enterpriseBasic.getStoreInfo().get(i).getDisplayNum());
            List<StoreInfo> storeInfoList = storeInfoMapper.selectByExample(exampleStore);
            if(storeInfoList.size() < 1){
                StoreInfo storeInfo = new StoreInfo();
                BeanUtils.copyProperties(enterpriseBasic.getStoreInfo().get(i),storeInfo);
                storeInfo.setCreateTime(new Date());
                storeInfoMapper.insertSelective(storeInfo);
            }
        }
        //新增公司信息
        int companySize = enterpriseBasic.getCompanyInfo().size();
        for (int i=0;i<companySize;i++){
            Example exampleCompany = new Example(CompanyInfo.class);
            exampleCompany.createCriteria().andEqualTo("memberId", memberId).andEqualTo("displayNum",
                    enterpriseBasic.getCompanyInfo().get(i).getDisplayNum());
            List<CompanyInfo> companyInfoList = companyInfoMapper.selectByExample(exampleCompany);
            if(companyInfoList.size() < 1){
                CompanyInfo companyInfo = new CompanyInfo();
                BeanUtils.copyProperties(enterpriseBasic.getCompanyInfo().get(i),companyInfo);
                companyInfo.setCreateTime(new Date());
                companyInfoMapper.insertSelective(companyInfo);
            }
        }
        return new BaseResponse();
    }

    @Override
    public BaseResponse updateEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        String memberId = enterpriseBasic.getMemberId();
        if(memberId == null || "".equals(memberId) ){
            return new BaseResponse(501,"没有商户ID，更新相关信息失败");
        }
        EnterpriseBasicInfo basicInfo = new EnterpriseBasicInfo();
        BeanUtils.copyProperties(enterpriseBasic,basicInfo);
        //基本信息
        basicInfo.setCreateTime(new Date());
        enterpriseBasicInfoMapper.updateByPrimaryKeySelective(basicInfo);
        //商店信息
        int StoreSize = enterpriseBasic.getStoreInfo().size();
        for (int i=0;i<StoreSize;i++){
            StoreInfo storeInfo = new StoreInfo();
            BeanUtils.copyProperties(enterpriseBasic.getStoreInfo().get(i),storeInfo);
            Example exampleStore = new Example(StoreInfo.class);
            exampleStore.createCriteria().andEqualTo("memberId", memberId).andEqualTo("displayNum",
                    enterpriseBasic.getStoreInfo().get(i).getDisplayNum());
            storeInfoMapper.updateByExample(storeInfo,exampleStore);
        }
        //公司信息
        int companySize = enterpriseBasic.getCompanyInfo().size();
        for (int i=0;i<companySize;i++){
            CompanyInfo companyInfo = new CompanyInfo();
            BeanUtils.copyProperties(enterpriseBasic.getStoreInfo().get(i),companyInfo);
            Example exampleCompany = new Example(CompanyInfo.class);
            exampleCompany.createCriteria().andEqualTo("memberId", memberId).andEqualTo("displayNum",
                    enterpriseBasic.getCompanyInfo().get(i).getDisplayNum());
            companyInfoMapper.updateByExample(companyInfo,exampleCompany);
        }
        return new BaseResponse();
    }

    @Override
    public EnterpriseBasic queryEnterpriseBasicInfo(String memberId) {

        return null;
    }

    @Override
    public BaseResponse deleteEnterpriseBasicInfo(String memberId) {
        return null;
    }
}
