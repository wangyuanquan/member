package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_enterprise_basic_info")
public class EnterpriseBasicInfo {
    @Id
    private Integer id;

    /**
     * 商家名称
     */
    @Column(name = "member_id")
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
    @Column(name = "post_code")
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
    @Column(name = "contact_name")
    private String contactName;

    /**
     * 主要联系人：手机号
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 主要联系人：职称
     */
    @Column(name = "contact_title")
    private String contactTitle;

    /**
     * 账单：用户名
     */
    @Column(name = "bill_name")
    private String billName;

    /**
     * 账单：银行名称
     */
    @Column(name = "bill_bank")
    private String billBank;

    /**
     * 账单：BSB账号
     */
    @Column(name = "bill_bbs_account")
    private String billBbsAccount;

    /**
     * 账单：上传文件信息
     */
    @Column(name = "bill_file_path")
    private String billFilePath;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取商家名称
     *
     * @return member_id - 商家名称
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置商家名称
     *
     * @param memberId 商家名称
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取商家地址
     *
     * @return address - 商家地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置商家地址
     *
     * @param address 商家地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取商家地址：市郊
     *
     * @return suburb - 商家地址：市郊
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     * 设置商家地址：市郊
     *
     * @param suburb 商家地址：市郊
     */
    public void setSuburb(String suburb) {
        this.suburb = suburb == null ? null : suburb.trim();
    }

    /**
     * 获取商家地址：州
     *
     * @return state - 商家地址：州
     */
    public String getState() {
        return state;
    }

    /**
     * 设置商家地址：州
     *
     * @param state 商家地址：州
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取商家地址：邮编
     *
     * @return post_code - 商家地址：邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 设置商家地址：邮编
     *
     * @param postCode 商家地址：邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 获取商家：联系电话
     *
     * @return phone - 商家：联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置商家：联系电话
     *
     * @param phone 商家：联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取商家：电子邮件地址
     *
     * @return email - 商家：电子邮件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置商家：电子邮件地址
     *
     * @param email 商家：电子邮件地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取主要联系人：全名
     *
     * @return contact_name - 主要联系人：全名
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置主要联系人：全名
     *
     * @param contactName 主要联系人：全名
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 获取主要联系人：手机号
     *
     * @return contact_phone - 主要联系人：手机号
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置主要联系人：手机号
     *
     * @param contactPhone 主要联系人：手机号
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * 获取主要联系人：职称
     *
     * @return contact_title - 主要联系人：职称
     */
    public String getContactTitle() {
        return contactTitle;
    }

    /**
     * 设置主要联系人：职称
     *
     * @param contactTitle 主要联系人：职称
     */
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle == null ? null : contactTitle.trim();
    }

    /**
     * 获取账单：用户名
     *
     * @return bill_name - 账单：用户名
     */
    public String getBillName() {
        return billName;
    }

    /**
     * 设置账单：用户名
     *
     * @param billName 账单：用户名
     */
    public void setBillName(String billName) {
        this.billName = billName == null ? null : billName.trim();
    }

    /**
     * 获取账单：银行名称
     *
     * @return bill_bank - 账单：银行名称
     */
    public String getBillBank() {
        return billBank;
    }

    /**
     * 设置账单：银行名称
     *
     * @param billBank 账单：银行名称
     */
    public void setBillBank(String billBank) {
        this.billBank = billBank == null ? null : billBank.trim();
    }

    /**
     * 获取账单：BSB账号
     *
     * @return bill_bbs_account - 账单：BSB账号
     */
    public String getBillBbsAccount() {
        return billBbsAccount;
    }

    /**
     * 设置账单：BSB账号
     *
     * @param billBbsAccount 账单：BSB账号
     */
    public void setBillBbsAccount(String billBbsAccount) {
        this.billBbsAccount = billBbsAccount == null ? null : billBbsAccount.trim();
    }

    /**
     * 获取账单：上传文件信息
     *
     * @return bill_file_path - 账单：上传文件信息
     */
    public String getBillFilePath() {
        return billFilePath;
    }

    /**
     * 设置账单：上传文件信息
     *
     * @param billFilePath 账单：上传文件信息
     */
    public void setBillFilePath(String billFilePath) {
        this.billFilePath = billFilePath == null ? null : billFilePath.trim();
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
}