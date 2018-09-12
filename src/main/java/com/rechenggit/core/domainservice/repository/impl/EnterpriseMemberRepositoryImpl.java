package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.CompanyInfo;
import com.rechenggit.core.dal.dataobject.EnterpriseBasicInfo;
import com.rechenggit.core.dal.dataobject.StoreInfo;
import com.rechenggit.core.dal.mapper.CompanyInfoMapper;
import com.rechenggit.core.dal.mapper.EnterpriseBasicInfoMapper;
import com.rechenggit.core.dal.mapper.StoreInfoMapper;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseCompany;
import com.rechenggit.core.domain.EnterpriseStore;
import com.rechenggit.core.domainservice.repository.EnterpriseMemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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
        //保存基本信息
        Example exampleBasic = new Example(EnterpriseBasicInfo.class);
        exampleBasic.createCriteria().andEqualTo("memberId", memberId);
        List<EnterpriseBasicInfo> basicInfoList = enterpriseBasicInfoMapper.selectByExample(exampleBasic);
        EnterpriseBasicInfo basicInfo = new EnterpriseBasicInfo();
        BeanUtils.copyProperties(enterpriseBasic,basicInfo);
        if(basicInfoList.isEmpty()){
            basicInfo.setCreateTime(new Date());
            enterpriseBasicInfoMapper.insertSelective(basicInfo);
        }else{
            enterpriseBasicInfoMapper.updateByExample(basicInfo,exampleBasic);
        }
        //保存商店信息
        int StoreSize = enterpriseBasic.getStoreInfo().size();
        for (int i=0;i<StoreSize;i++){
            /*
            if(enterpriseBasic.getStoreInfo().get(i).getDisplayNum() == null){
                return new BaseResponse(504,"参数错误");
            }*/
            Example exampleStore = new Example(StoreInfo.class);
            exampleStore.createCriteria().andEqualTo("memberId", memberId).andEqualTo("displayNum",
                    enterpriseBasic.getStoreInfo().get(i).getDisplayNum());
            List<StoreInfo> storeInfoList = storeInfoMapper.selectByExample(exampleStore);
            StoreInfo storeInfo = new StoreInfo();
            BeanUtils.copyProperties(enterpriseBasic.getStoreInfo().get(i),storeInfo);
            if(storeInfoList.isEmpty()){
                storeInfo.setCreateTime(new Date());
                storeInfoMapper.insertSelective(storeInfo);
            }else{
                storeInfoMapper.updateByExample(storeInfo,exampleStore);
            }
        }
        //保存公司信息
        int companySize = enterpriseBasic.getCompanyInfo().size();
        for (int i=0;i<companySize;i++){
            Example exampleCompany = new Example(CompanyInfo.class);
            exampleCompany.createCriteria().andEqualTo("memberId", memberId).andEqualTo("displayNum",
                    enterpriseBasic.getCompanyInfo().get(i).getDisplayNum());
            List<CompanyInfo> companyInfoList = companyInfoMapper.selectByExample(exampleCompany);
            CompanyInfo companyInfo = new CompanyInfo();
            BeanUtils.copyProperties(enterpriseBasic.getCompanyInfo().get(i),companyInfo);
            if(companyInfoList.isEmpty()){
                companyInfo.setCreateTime(new Date());
                companyInfoMapper.insertSelective(companyInfo);
            }else{
                companyInfoMapper.updateByExample(companyInfo,exampleCompany);
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
        EnterpriseBasic enterpriseBasic = new EnterpriseBasic();
        //基本信息
        Example exampleBasicInfo = new Example(EnterpriseBasicInfo.class);
        exampleBasicInfo.createCriteria().andEqualTo("memberId", memberId);
        List<EnterpriseBasicInfo> basicInfo = enterpriseBasicInfoMapper.selectByExample(exampleBasicInfo);
        BeanUtils.copyProperties(basicInfo.get(0),enterpriseBasic);
        //商店
        Example exampleStore = new Example(StoreInfo.class);
        exampleStore.createCriteria().andEqualTo("memberId", memberId);
        List<StoreInfo> storeInfo = storeInfoMapper.selectByExample(exampleStore);
        List<EnterpriseStore> enterpriseStoreList = new ArrayList<>();
        for (int i=0;i<storeInfo.size();i++){
            EnterpriseStore enterpriseStore = new EnterpriseStore();
            BeanUtils.copyProperties(storeInfo.get(i),enterpriseStore);
            enterpriseStoreList.add(enterpriseStore);
        }
        enterpriseBasic.setStoreInfo(enterpriseStoreList);
        //公司
        Example exampleCompany = new Example(CompanyInfo.class);
        exampleCompany.createCriteria().andEqualTo("memberId", memberId);
        List<CompanyInfo> companyInfo = companyInfoMapper.selectByExample(exampleCompany);
        List<EnterpriseCompany> enterpriseCompanyList = new ArrayList<>();
        for (int i=0;i<companyInfo.size();i++){
            EnterpriseCompany enterpriseCompany = new EnterpriseCompany();
            BeanUtils.copyProperties(companyInfo.get(i),enterpriseCompany);
            enterpriseCompanyList.add(enterpriseCompany);
        }
        enterpriseBasic.setCompanyInfo(enterpriseCompanyList);
        return enterpriseBasic;
    }

    @Override
    public BaseResponse deleteEnterpriseBasicInfo(String memberId) {
        //基本信息
        Example exampleBasicInfo = new Example(EnterpriseBasicInfo.class);
        exampleBasicInfo.createCriteria().andEqualTo("memberId", memberId);
        int num = enterpriseBasicInfoMapper.deleteByExample(exampleBasicInfo);
        //商店
        Example exampleStore = new Example(StoreInfo.class);
        exampleStore.createCriteria().andEqualTo("memberId", memberId);
        num += storeInfoMapper.deleteByExample(exampleStore);
        //公司
        Example exampleCompany = new Example(CompanyInfo.class);
        exampleCompany.createCriteria().andEqualTo("memberId", memberId);
        num += companyInfoMapper.deleteByExample(exampleCompany);
        if(num < 1){
            return new BaseResponse(503,"无相关信息");
        }
        return new BaseResponse();
    }
}
