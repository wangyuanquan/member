package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_store_info")
public class StoreInfo {
    @Id
    private Integer id;

    @Column(name = "member_id")
    private String memberId;

    /**
     * 页面展示序号
     */
    @Column(name = "display_num")
    private Byte displayNum;

    /**
     * 商店名称
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 商店地址
     */
    @Column(name = "store_address")
    private String storeAddress;

    /**
     * 商店地址：市郊
     */
    @Column(name = "store_suburb")
    private String storeSuburb;

    /**
     * 商店地址：州
     */
    @Column(name = "store_state")
    private String storeState;

    /**
     * 商店地址：邮编
     */
    @Column(name = "store_post_code")
    private String storePostCode;

    /**
     * 商店：联系电话
     */
    @Column(name = "store_phone")
    private String storePhone;

    /**
     * 商店：电子邮件地址
     */
    @Column(name = "store_email")
    private String storeEmail;

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
     * @return member_id
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取页面展示序号
     *
     * @return display_num - 页面展示序号
     */
    public Byte getDisplayNum() {
        return displayNum;
    }

    /**
     * 设置页面展示序号
     *
     * @param displayNum 页面展示序号
     */
    public void setDisplayNum(Byte displayNum) {
        this.displayNum = displayNum;
    }

    /**
     * 获取商店名称
     *
     * @return store_name - 商店名称
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置商店名称
     *
     * @param storeName 商店名称
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * 获取商店地址
     *
     * @return store_address - 商店地址
     */
    public String getStoreAddress() {
        return storeAddress;
    }

    /**
     * 设置商店地址
     *
     * @param storeAddress 商店地址
     */
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    /**
     * 获取商店地址：市郊
     *
     * @return store_suburb - 商店地址：市郊
     */
    public String getStoreSuburb() {
        return storeSuburb;
    }

    /**
     * 设置商店地址：市郊
     *
     * @param storeSuburb 商店地址：市郊
     */
    public void setStoreSuburb(String storeSuburb) {
        this.storeSuburb = storeSuburb == null ? null : storeSuburb.trim();
    }

    /**
     * 获取商店地址：州
     *
     * @return store_state - 商店地址：州
     */
    public String getStoreState() {
        return storeState;
    }

    /**
     * 设置商店地址：州
     *
     * @param storeState 商店地址：州
     */
    public void setStoreState(String storeState) {
        this.storeState = storeState == null ? null : storeState.trim();
    }

    /**
     * 获取商店地址：邮编
     *
     * @return store_post_code - 商店地址：邮编
     */
    public String getStorePostCode() {
        return storePostCode;
    }

    /**
     * 设置商店地址：邮编
     *
     * @param storePostCode 商店地址：邮编
     */
    public void setStorePostCode(String storePostCode) {
        this.storePostCode = storePostCode == null ? null : storePostCode.trim();
    }

    /**
     * 获取商店：联系电话
     *
     * @return store_phone - 商店：联系电话
     */
    public String getStorePhone() {
        return storePhone;
    }

    /**
     * 设置商店：联系电话
     *
     * @param storePhone 商店：联系电话
     */
    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone == null ? null : storePhone.trim();
    }

    /**
     * 获取商店：电子邮件地址
     *
     * @return store_email - 商店：电子邮件地址
     */
    public String getStoreEmail() {
        return storeEmail;
    }

    /**
     * 设置商店：电子邮件地址
     *
     * @param storeEmail 商店：电子邮件地址
     */
    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail == null ? null : storeEmail.trim();
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