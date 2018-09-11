package com.rechenggit.core.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class EnterpriseStore {

    private String memberId;

    /**
     * 商店名称
     */
    private String storeName;

    /**
     * 页面展示序号
     */
    private Byte displayNum;

    /**
     * 商店地址
     */
    private String storeAddress;

    /**
     * 商店地址：市郊
     */
    private String storeSuburb;

    /**
     * 商店地址：州
     */
    private String storeState;

    /**
     * 商店地址：邮编
     */
    private String storePostCode;

    /**
     * 商店：联系电话
     */
    private String storePhone;

    /**
     * 商店：电子邮件地址
     */
    private String storeEmail;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreSuburb() {
        return storeSuburb;
    }

    public void setStoreSuburb(String storeSuburb) {
        this.storeSuburb = storeSuburb;
    }

    public String getStoreState() {
        return storeState;
    }

    public void setStoreState(String storeState) {
        this.storeState = storeState;
    }

    public String getStorePostCode() {
        return storePostCode;
    }

    public void setStorePostCode(String storePostCode) {
        this.storePostCode = storePostCode;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public Byte getDisplayNum() {
        return displayNum;
    }

    public void setDisplayNum(Byte displayNum) {
        this.displayNum = displayNum;
    }
}
