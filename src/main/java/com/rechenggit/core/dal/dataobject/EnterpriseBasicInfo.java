package com.rechenggit.core.dal.dataobject;

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

    @Column(name = "mer_name")
    private String merName;

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
    @Column(name = "bbs_number")
    private String bbsNumber;

    /**
     * 账单-上传文件信息
     */
    @Column(name = "file_path")
    private String filePath;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private String type;

    private String rate;

    @Column(name = "profit_distribution")
    private Integer profitDistribution;

    @Column(name = "settlement_cycle")
    private String settlementCycle;

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
     * @return mer_name
     */
    public String getMerName() {
        return merName;
    }

    /**
     * @param merName
     */
    public void setMerName(String merName) {
        this.merName = merName == null ? null : merName.trim();
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
     * @return bbs_number - 账单-BSB账号
     */
    public String getBbsNumber() {
        return bbsNumber;
    }

    /**
     * 设置账单-BSB账号
     *
     * @param bbsNumber 账单-BSB账号
     */
    public void setBbsNumber(String bbsNumber) {
        this.bbsNumber = bbsNumber == null ? null : bbsNumber.trim();
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
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return rate
     */
    public String getRate() {
        return rate;
    }

    /**
     * @param rate
     */
    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    /**
     * @return profit_distribution
     */
    public Integer getProfitDistribution() {
        return profitDistribution;
    }

    /**
     * @param profitDistribution
     */
    public void setProfitDistribution(Integer profitDistribution) {
        this.profitDistribution = profitDistribution;
    }

    /**
     * @return settlement_cycle
     */
    public String getSettlementCycle() {
        return settlementCycle;
    }

    /**
     * @param settlementCycle
     */
    public void setSettlementCycle(String settlementCycle) {
        this.settlementCycle = settlementCycle == null ? null : settlementCycle.trim();
    }

    /**
     * @return uploading_files
     */
    public String getUploadingFiles() {
        return uploadingFiles;
    }

    /**
     * @param uploadingFiles
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
}