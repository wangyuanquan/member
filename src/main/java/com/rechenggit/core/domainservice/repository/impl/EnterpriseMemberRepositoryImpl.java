package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.*;
import com.rechenggit.core.dal.mapper.*;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseCompany;
import com.rechenggit.core.domain.EnterpriseOther;
import com.rechenggit.core.domain.EnterpriseStore;
import com.rechenggit.core.domainservice.repository.EnterpriseMemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Repository
public class EnterpriseMemberRepositoryImpl implements EnterpriseMemberRepository {

    @Autowired
    private EnterpriseBasicInfoMapper enterpriseBasicInfoMapper;
    @Autowired
    private StoreInfoMapper storeInfoMapper;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;
    @Autowired
    private EnterpriseOtherInfoMapper enterpriseOtherInfoMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public BaseResponse saveEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        String memberId = enterpriseBasic.getMemberId();
        if(memberId == null || "".equals(memberId) ){
            return new BaseResponse(501,"parameter.invalid");
        }
        //保存商家名称tm_member
        Example exampleMember = new Example(Member.class);
        exampleMember.createCriteria().andEqualTo("memberId", memberId);
        List<Member> memberList = memberMapper.selectByExample(exampleMember);
        if(memberList.isEmpty()){
            return new BaseResponse(501,"parameter.invalid");
        }else{
            Member member = new Member();
            member.setMemberName(enterpriseBasic.getMerName());
            memberMapper.updateByExampleSelective(member,exampleMember);
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
            enterpriseBasicInfoMapper.updateByExampleSelective(basicInfo,exampleBasic);
        }
        //保存商店信息 先删后添
        Example exampleStore = new Example(StoreInfo.class);
        exampleStore.createCriteria().andEqualTo("memberId", memberId);
        storeInfoMapper.deleteByExample(exampleStore);
        int StoreSize = enterpriseBasic.getStoreInfo().size();
        for (int i=0;i<StoreSize;i++){
            StoreInfo storeInfo = new StoreInfo();
            BeanUtils.copyProperties(enterpriseBasic.getStoreInfo().get(i),storeInfo);
            storeInfo.setMemberId(memberId);
            storeInfo.setCreateTime(new Date());
            storeInfoMapper.insertSelective(storeInfo);
        }
        //保存公司信息 先删后添
        Example exampleCompany = new Example(CompanyInfo.class);
        exampleCompany.createCriteria().andEqualTo("memberId", memberId);
        companyInfoMapper.deleteByExample(exampleCompany);
        int companySize = enterpriseBasic.getCompanyInfo().size();
        for (int i=0;i<companySize;i++){
            CompanyInfo companyInfo = new CompanyInfo();
            BeanUtils.copyProperties(enterpriseBasic.getCompanyInfo().get(i),companyInfo);
            companyInfo.setMemberId(memberId);
            companyInfo.setCreateTime(new Date());
            companyInfoMapper.insertSelective(companyInfo);
        }
        return new BaseResponse();
    }

    @Override
    public BaseResponse updateEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic) {
        String memberId = enterpriseBasic.getMemberId();
        if(memberId == null || "".equals(memberId) ){
            return new BaseResponse(501,"parameter.invalid");
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
            storeInfoMapper.updateByExampleSelective(storeInfo,exampleStore);
        }
        //公司信息
        int companySize = enterpriseBasic.getCompanyInfo().size();
        for (int i=0;i<companySize;i++){
            CompanyInfo companyInfo = new CompanyInfo();
            BeanUtils.copyProperties(enterpriseBasic.getStoreInfo().get(i),companyInfo);
            Example exampleCompany = new Example(CompanyInfo.class);
            exampleCompany.createCriteria().andEqualTo("memberId", memberId).andEqualTo("displayNum",
                    enterpriseBasic.getCompanyInfo().get(i).getDisplayNum());
            companyInfoMapper.updateByExampleSelective(companyInfo,exampleCompany);
        }
        return new BaseResponse();
    }

    @Override
    public BaseResponse queryEnterpriseBasicInfo(String memberId) {
        BaseResponse baseResponse = new BaseResponse();
        EnterpriseBasic enterpriseBasic = new EnterpriseBasic();
        //商家名称
        Example exampleMember = new Example(Member.class);
        exampleMember.createCriteria().andEqualTo("memberId", memberId);
        List<Member> memberList = memberMapper.selectByExample(exampleMember);
        if(memberList.isEmpty()){
            return new BaseResponse(504,"parameter.invalid");
        }
        enterpriseBasic.setMerName(memberList.get(0).getMemberName());
        //基本信息
        Example exampleBasicInfo = new Example(EnterpriseBasicInfo.class);
        exampleBasicInfo.createCriteria().andEqualTo("memberId", memberId);
        List<EnterpriseBasicInfo> basicInfo = enterpriseBasicInfoMapper.selectByExample(exampleBasicInfo);
        if(basicInfo.isEmpty()){
            return new BaseResponse(504,"parameter.invalid");
        }
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
        baseResponse.setData(enterpriseBasic);
        return baseResponse;
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
            return new BaseResponse(503,"parameter.invalid");
        }
        return new BaseResponse();
    }

    @Override
    public BaseResponse saveEnterpriseOtherInfo(EnterpriseOther enterpriseOther) {
        String memberId = enterpriseOther.getMemberId();
        if(memberId == null || "".equals(memberId) ){
            return new BaseResponse(501,"parameter.invalid");
        }
        //保存其他信息
        Example exampleOther = new Example(EnterpriseOtherInfo.class);
        exampleOther.createCriteria().andEqualTo("memberId", memberId);
        List<EnterpriseOtherInfo> basicOtherList = enterpriseOtherInfoMapper.selectByExample(exampleOther);
        EnterpriseOtherInfo basicOther = new EnterpriseOtherInfo();
        BeanUtils.copyProperties(enterpriseOther,basicOther);
        if(basicOtherList.isEmpty()){
            basicOther.setCreateTime(new Date());
            enterpriseOtherInfoMapper.insertSelective(basicOther);
        }else{
            enterpriseOtherInfoMapper.updateByExampleSelective(basicOther,exampleOther);
        }
        return new BaseResponse();
    }

    @Override
    public BaseResponse queryEnterpriseOtherInfo(String memberId) {
        BaseResponse baseResponse = new BaseResponse();
        EnterpriseOther enterpriseOther = new EnterpriseOther();
        Example exampleBasicOther = new Example(EnterpriseOtherInfo.class);
        exampleBasicOther.createCriteria().andEqualTo("memberId", memberId);
        List<EnterpriseOtherInfo> basicOther = enterpriseOtherInfoMapper.selectByExample(exampleBasicOther);
        if(basicOther.isEmpty()){
            return new BaseResponse(504,"parameter.invalid");
        }
        BeanUtils.copyProperties(basicOther.get(0),enterpriseOther);
        baseResponse.setData(enterpriseOther);
        return baseResponse;
    }

    @Override
    public BaseResponse deleteEnterpriseOtherInfo(String memberId) {
        Example exampleOtherInfo = new Example(EnterpriseOtherInfo.class);
        exampleOtherInfo.createCriteria().andEqualTo("memberId", memberId);
        int num = enterpriseOtherInfoMapper.deleteByExample(exampleOtherInfo);
        if(num < 1){
            return new BaseResponse(503,"parameter.invalid");
        }
        return new BaseResponse();
    }
}
