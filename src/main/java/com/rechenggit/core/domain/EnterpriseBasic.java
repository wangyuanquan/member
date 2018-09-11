package com.rechenggit.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
public class EnterpriseBasic {

    /**
     * 商家名称
     */
    private String memberId;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 商家地址：市郊
     */
    private String suburb;

    /**
     * 商家地址：州
     */
    private String state;

    /**
     * 商家地址：邮编
     */
    private String postCode;

    /**
     * 商家：联系电话
     */
    private String phone;

    /**
     * 商家：电子邮件地址
     */
    private String email;

    /**
     * 主要联系人：全名
     */
    private String contactName;

    /**
     * 主要联系人：手机号
     */

    private String contactPhone;

    /**
     * 主要联系人：职称
     */
    private String contactTitle;

    /**
     * 账单：用户名
     */
    private String billName;

    /**
     * 账单：银行名称
     */
    private String billBank;

    /**
     * 账单：BSB账号
     */
    private String billBbsAccount;

    /**
     * 账单：上传文件信息
     */
    private String billFilePath;

    /**
     * 商店信息
     */
    private List<EnterpriseStore> storeInfo;

    /**
     * 公司信息
     */
    private List<EnterpriseCompany> companyInfo;

    /**
     * 商店信息id
     */
    private String storeInfoId;

    /**
     * 公司信息id
     */
    private String companyInfoId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillBank() {
        return billBank;
    }

    public void setBillBank(String billBank) {
        this.billBank = billBank;
    }

    public String getBillBbsAccount() {
        return billBbsAccount;
    }

    public void setBillBbsAccount(String billBbsAccount) {
        this.billBbsAccount = billBbsAccount;
    }

    public String getBillFilePath() {
        return billFilePath;
    }

    public void setBillFilePath(String billFilePath) {
        this.billFilePath = billFilePath;
    }

    public List<EnterpriseStore> getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(List<EnterpriseStore> storeInfo) {
        this.storeInfo = storeInfo;
    }

    public List<EnterpriseCompany> getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(List<EnterpriseCompany> companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getStoreInfoId() {
        return storeInfoId;
    }

    public void setStoreInfoId(String storeInfoId) {
        this.storeInfoId = storeInfoId;
    }
}
