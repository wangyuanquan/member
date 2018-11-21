package com.anole.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_enterprise_basic_info")
public class EnterpriseBasicInfo {
    @Id
    private Integer id;

    /**
     * 商家ID
     */
    @Column(name = "member_id")
    private String memberId;

    /**
     * 商家地址
     */
    @Column(name = "mer_address")
    private String merAddress;

    /**
     * 商家地址-市郊
     */
    @Column(name = "mer_suburb")
    private String merSuburb;

    /**
     * 商家地址-州
     */
    @Column(name = "mer_state")
    private String merState;

    /**
     * 商家地址-邮编
     */
    @Column(name = "mer_post_code")
    private String merPostCode;

    /**
     * 商家-联系电话
     */
    @Column(name = "mer_phone")
    private String merPhone;

    /**
     * 商家-电子邮件地址
     */
    @Column(name = "mer_email")
    private String merEmail;

    /**
     * 主要联系人-全名
     */
    @Column(name = "contact_name")
    private String contactName;

    /**
     * 主要联系人-手机号
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 主要联系人-职称
     */
    @Column(name = "contact_title")
    private String contactTitle;

    /**
     * 账单-用户名
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 账单-银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 账单-BSB账号
     */
    @Column(name = "bsb_number")
    private String bsbNumber;

    /**
     * 账单-上传文件信息
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 类型
     */
    private String type;

    /**
     * 分润比例
     */
    @Column(name = "profit_distribution")
    private Integer profitDistribution;

    /**
     * 结算周期
     */
    @Column(name = "settlement_cycle")
    private String settlementCycle;

    /**
     * 上传文件
     */
    @Column(name = "uploading_files")
    private String uploadingFiles;

    /**
     * 公司注册-名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司注册-支持票据(ABN)
     */
    @Column(name = "company_abn")
    private String companyAbn;

    /**
     * 公司注册-税号(ACN)
     */
    @Column(name = "company_acn")
    private String companyAcn;

    /**
     * 公司注册-行业
     */
    @Column(name = "company_industry")
    private String companyIndustry;

    /**
     * 公司注册-地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 注册地址-市郊
     */
    @Column(name = "company_suburb")
    private String companySuburb;

    /**
     * 注册地址-州
     */
    @Column(name = "company_state")
    private String companyState;

    /**
     * 注册地址-邮政编码
     */
    @Column(name = "company_postcode")
    private String companyPostcode;

    /**
     * 手续费费率
     */
    private String rate;

    /**
     * 类别
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 子类别
     */
    @Column(name = "sub_category_id")
    private String subCategoryId;

    /**
     * 类别
     */
    private String category;

    /**
     * 子类别
     */
    @Column(name = "sub_category")
    private String subCategory;

    /**
     * bdManager
     */
    @Column(name = "bd_manager")
    private String bdManager;

    /**
     * 头像
     */
    @Column(name = "title_photo")
    private String titlePhoto;

    /**
     * 是否线下签约 1.签约 0未签约
     */
    @Column(name = "offline_contract_signed")
    private String offlineContractSigned;

    /**
     * 合同上传osskey
     */
    @Column(name = "offline_contract_oss_key")
    private String offlineContractOssKey;

    /**
     * 联系任邮箱
     */
    @Column(name = "contact_email")
    private String contactEmail;

    /**
     * 银行账号
     */
    @Column(name = "account_number")
    private String accountNumber;

    /**
     * 银行区域
     */
    @Column(name = "bank_region")
    private String bankRegion;

    /**
     * Market material status: 0.not sent 1.sent 2.bd send
     */
    @Column(name = "market_material_status")
    private String marketMaterialStatus;

    @Column(name = "bbs_number")
    private String bbsNumber;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商家ID
     *
     * @return member_id - 商家ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置商家ID
     *
     * @param memberId 商家ID
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取商家地址
     *
     * @return mer_address - 商家地址
     */
    public String getMerAddress() {
        return merAddress;
    }

    /**
     * 设置商家地址
     *
     * @param merAddress 商家地址
     */
    public void setMerAddress(String merAddress) {
        this.merAddress = merAddress == null ? null : merAddress.trim();
    }

    /**
     * 获取商家地址-市郊
     *
     * @return mer_suburb - 商家地址-市郊
     */
    public String getMerSuburb() {
        return merSuburb;
    }

    /**
     * 设置商家地址-市郊
     *
     * @param merSuburb 商家地址-市郊
     */
    public void setMerSuburb(String merSuburb) {
        this.merSuburb = merSuburb == null ? null : merSuburb.trim();
    }

    /**
     * 获取商家地址-州
     *
     * @return mer_state - 商家地址-州
     */
    public String getMerState() {
        return merState;
    }

    /**
     * 设置商家地址-州
     *
     * @param merState 商家地址-州
     */
    public void setMerState(String merState) {
        this.merState = merState == null ? null : merState.trim();
    }

    /**
     * 获取商家地址-邮编
     *
     * @return mer_post_code - 商家地址-邮编
     */
    public String getMerPostCode() {
        return merPostCode;
    }

    /**
     * 设置商家地址-邮编
     *
     * @param merPostCode 商家地址-邮编
     */
    public void setMerPostCode(String merPostCode) {
        this.merPostCode = merPostCode == null ? null : merPostCode.trim();
    }

    /**
     * 获取商家-联系电话
     *
     * @return mer_phone - 商家-联系电话
     */
    public String getMerPhone() {
        return merPhone;
    }

    /**
     * 设置商家-联系电话
     *
     * @param merPhone 商家-联系电话
     */
    public void setMerPhone(String merPhone) {
        this.merPhone = merPhone == null ? null : merPhone.trim();
    }

    /**
     * 获取商家-电子邮件地址
     *
     * @return mer_email - 商家-电子邮件地址
     */
    public String getMerEmail() {
        return merEmail;
    }

    /**
     * 设置商家-电子邮件地址
     *
     * @param merEmail 商家-电子邮件地址
     */
    public void setMerEmail(String merEmail) {
        this.merEmail = merEmail == null ? null : merEmail.trim();
    }

    /**
     * 获取主要联系人-全名
     *
     * @return contact_name - 主要联系人-全名
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置主要联系人-全名
     *
     * @param contactName 主要联系人-全名
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 获取主要联系人-手机号
     *
     * @return contact_phone - 主要联系人-手机号
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置主要联系人-手机号
     *
     * @param contactPhone 主要联系人-手机号
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * 获取主要联系人-职称
     *
     * @return contact_title - 主要联系人-职称
     */
    public String getContactTitle() {
        return contactTitle;
    }

    /**
     * 设置主要联系人-职称
     *
     * @param contactTitle 主要联系人-职称
     */
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle == null ? null : contactTitle.trim();
    }

    /**
     * 获取账单-用户名
     *
     * @return account_name - 账单-用户名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置账单-用户名
     *
     * @param accountName 账单-用户名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * 获取账单-银行名称
     *
     * @return bank_name - 账单-银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置账单-银行名称
     *
     * @param bankName 账单-银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取账单-BSB账号
     *
     * @return bsb_number - 账单-BSB账号
     */
    public String getBsbNumber() {
        return bsbNumber;
    }

    /**
     * 设置账单-BSB账号
     *
     * @param bsbNumber 账单-BSB账号
     */
    public void setBsbNumber(String bsbNumber) {
        this.bsbNumber = bsbNumber == null ? null : bsbNumber.trim();
    }

    /**
     * 获取账单-上传文件信息
     *
     * @return file_path - 账单-上传文件信息
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置账单-上传文件信息
     *
     * @param filePath 账单-上传文件信息
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取分润比例
     *
     * @return profit_distribution - 分润比例
     */
    public Integer getProfitDistribution() {
        return profitDistribution;
    }

    /**
     * 设置分润比例
     *
     * @param profitDistribution 分润比例
     */
    public void setProfitDistribution(Integer profitDistribution) {
        this.profitDistribution = profitDistribution;
    }

    /**
     * 获取结算周期
     *
     * @return settlement_cycle - 结算周期
     */
    public String getSettlementCycle() {
        return settlementCycle;
    }

    /**
     * 设置结算周期
     *
     * @param settlementCycle 结算周期
     */
    public void setSettlementCycle(String settlementCycle) {
        this.settlementCycle = settlementCycle == null ? null : settlementCycle.trim();
    }

    /**
     * 获取上传文件
     *
     * @return uploading_files - 上传文件
     */
    public String getUploadingFiles() {
        return uploadingFiles;
    }

    /**
     * 设置上传文件
     *
     * @param uploadingFiles 上传文件
     */
    public void setUploadingFiles(String uploadingFiles) {
        this.uploadingFiles = uploadingFiles == null ? null : uploadingFiles.trim();
    }

    /**
     * 获取公司注册-名称
     *
     * @return company_name - 公司注册-名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司注册-名称
     *
     * @param companyName 公司注册-名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取公司注册-支持票据(ABN)
     *
     * @return company_abn - 公司注册-支持票据(ABN)
     */
    public String getCompanyAbn() {
        return companyAbn;
    }

    /**
     * 设置公司注册-支持票据(ABN)
     *
     * @param companyAbn 公司注册-支持票据(ABN)
     */
    public void setCompanyAbn(String companyAbn) {
        this.companyAbn = companyAbn == null ? null : companyAbn.trim();
    }

    /**
     * 获取公司注册-税号(ACN)
     *
     * @return company_acn - 公司注册-税号(ACN)
     */
    public String getCompanyAcn() {
        return companyAcn;
    }

    /**
     * 设置公司注册-税号(ACN)
     *
     * @param companyAcn 公司注册-税号(ACN)
     */
    public void setCompanyAcn(String companyAcn) {
        this.companyAcn = companyAcn == null ? null : companyAcn.trim();
    }

    /**
     * 获取公司注册-行业
     *
     * @return company_industry - 公司注册-行业
     */
    public String getCompanyIndustry() {
        return companyIndustry;
    }

    /**
     * 设置公司注册-行业
     *
     * @param companyIndustry 公司注册-行业
     */
    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry == null ? null : companyIndustry.trim();
    }

    /**
     * 获取公司注册-地址
     *
     * @return company_address - 公司注册-地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置公司注册-地址
     *
     * @param companyAddress 公司注册-地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    /**
     * 获取注册地址-市郊
     *
     * @return company_suburb - 注册地址-市郊
     */
    public String getCompanySuburb() {
        return companySuburb;
    }

    /**
     * 设置注册地址-市郊
     *
     * @param companySuburb 注册地址-市郊
     */
    public void setCompanySuburb(String companySuburb) {
        this.companySuburb = companySuburb == null ? null : companySuburb.trim();
    }

    /**
     * 获取注册地址-州
     *
     * @return company_state - 注册地址-州
     */
    public String getCompanyState() {
        return companyState;
    }

    /**
     * 设置注册地址-州
     *
     * @param companyState 注册地址-州
     */
    public void setCompanyState(String companyState) {
        this.companyState = companyState == null ? null : companyState.trim();
    }

    /**
     * 获取注册地址-邮政编码
     *
     * @return company_postcode - 注册地址-邮政编码
     */
    public String getCompanyPostcode() {
        return companyPostcode;
    }

    /**
     * 设置注册地址-邮政编码
     *
     * @param companyPostcode 注册地址-邮政编码
     */
    public void setCompanyPostcode(String companyPostcode) {
        this.companyPostcode = companyPostcode == null ? null : companyPostcode.trim();
    }

    /**
     * 获取手续费费率
     *
     * @return rate - 手续费费率
     */
    public String getRate() {
        return rate;
    }

    /**
     * 设置手续费费率
     *
     * @param rate 手续费费率
     */
    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    /**
     * 获取类别
     *
     * @return category_id - 类别
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类别
     *
     * @param categoryId 类别
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    /**
     * 获取子类别
     *
     * @return sub_category_id - 子类别
     */
    public String getSubCategoryId() {
        return subCategoryId;
    }

    /**
     * 设置子类别
     *
     * @param subCategoryId 子类别
     */
    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId == null ? null : subCategoryId.trim();
    }

    /**
     * 获取类别
     *
     * @return category - 类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置类别
     *
     * @param category 类别
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 获取子类别
     *
     * @return sub_category - 子类别
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * 设置子类别
     *
     * @param subCategory 子类别
     */
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory == null ? null : subCategory.trim();
    }

    /**
     * 获取bdManager
     *
     * @return bd_manager - bdManager
     */
    public String getBdManager() {
        return bdManager;
    }

    /**
     * 设置bdManager
     *
     * @param bdManager bdManager
     */
    public void setBdManager(String bdManager) {
        this.bdManager = bdManager == null ? null : bdManager.trim();
    }

    /**
     * 获取头像
     *
     * @return title_photo - 头像
     */
    public String getTitlePhoto() {
        return titlePhoto;
    }

    /**
     * 设置头像
     *
     * @param titlePhoto 头像
     */
    public void setTitlePhoto(String titlePhoto) {
        this.titlePhoto = titlePhoto == null ? null : titlePhoto.trim();
    }

    /**
     * 获取是否线下签约 1.签约 0未签约
     *
     * @return offline_contract_signed - 是否线下签约 1.签约 0未签约
     */
    public String getOfflineContractSigned() {
        return offlineContractSigned;
    }

    /**
     * 设置是否线下签约 1.签约 0未签约
     *
     * @param offlineContractSigned 是否线下签约 1.签约 0未签约
     */
    public void setOfflineContractSigned(String offlineContractSigned) {
        this.offlineContractSigned = offlineContractSigned == null ? null : offlineContractSigned.trim();
    }

    /**
     * 获取合同上传osskey
     *
     * @return offline_contract_oss_key - 合同上传osskey
     */
    public String getOfflineContractOssKey() {
        return offlineContractOssKey;
    }

    /**
     * 设置合同上传osskey
     *
     * @param offlineContractOssKey 合同上传osskey
     */
    public void setOfflineContractOssKey(String offlineContractOssKey) {
        this.offlineContractOssKey = offlineContractOssKey == null ? null : offlineContractOssKey.trim();
    }

    /**
     * 获取联系任邮箱
     *
     * @return contact_email - 联系任邮箱
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * 设置联系任邮箱
     *
     * @param contactEmail 联系任邮箱
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    /**
     * 获取银行账号
     *
     * @return account_number - 银行账号
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 设置银行账号
     *
     * @param accountNumber 银行账号
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    /**
     * 获取银行区域
     *
     * @return bank_region - 银行区域
     */
    public String getBankRegion() {
        return bankRegion;
    }

    /**
     * 设置银行区域
     *
     * @param bankRegion 银行区域
     */
    public void setBankRegion(String bankRegion) {
        this.bankRegion = bankRegion == null ? null : bankRegion.trim();
    }

    /**
     * 获取Market material status: 0.not sent 1.sent 2.bd send
     *
     * @return market_material_status - Market material status: 0.not sent 1.sent 2.bd send
     */
    public String getMarketMaterialStatus() {
        return marketMaterialStatus;
    }

    /**
     * 设置Market material status: 0.not sent 1.sent 2.bd send
     *
     * @param marketMaterialStatus Market material status: 0.not sent 1.sent 2.bd send
     */
    public void setMarketMaterialStatus(String marketMaterialStatus) {
        this.marketMaterialStatus = marketMaterialStatus == null ? null : marketMaterialStatus.trim();
    }

    /**
     * @return bbs_number
     */
    public String getBbsNumber() {
        return bbsNumber;
    }

    /**
     * @param bbsNumber
     */
    public void setBbsNumber(String bbsNumber) {
        this.bbsNumber = bbsNumber == null ? null : bbsNumber.trim();
    }
}