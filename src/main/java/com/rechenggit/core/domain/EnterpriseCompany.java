package com.rechenggit.core.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class EnterpriseCompany {

    private String memberId;

    /**
     * 公司注册：名称
     */
    private String companyName;

    /**
     * 页面展示序号
     */
    private Byte displayNum;

    /**
     * 公司注册支持票据（ABN）
     */
    private String companyAbn;

    /**
     * 公司注册：税号（ACN）
     */
    private String companyAcn;

    /**
     * 公司注册：行业
     */
    private String companyIndustry;

    /**
     * 公司注册：地址
     */
    private String companyAddress;

    /**
     * 注册地址：市郊
     */
    private String companySuburb;

    /**
     * 注册地址：州
     */
    private String companyState;

    /**
     * 注册地址：邮政编码
     */
    private String companyPostcode;

    /**
     * 注册信息：直接名称
     */
    private String directerName;

    /**
     * 图片（照片，执照，驾照）
     */
    private String photoId;

    /**
     * 图片类型
     */
    private Byte photoIdType;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Byte getDisplayNum() {
        return displayNum;
    }

    public void setDisplayNum(Byte displayNum) {
        this.displayNum = displayNum;
    }

    public String getCompanyAbn() {
        return companyAbn;
    }

    public void setCompanyAbn(String companyAbn) {
        this.companyAbn = companyAbn;
    }

    public String getCompanyAcn() {
        return companyAcn;
    }

    public void setCompanyAcn(String companyAcn) {
        this.companyAcn = companyAcn;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanySuburb() {
        return companySuburb;
    }

    public void setCompanySuburb(String companySuburb) {
        this.companySuburb = companySuburb;
    }

    public String getCompanyState() {
        return companyState;
    }

    public void setCompanyState(String companyState) {
        this.companyState = companyState;
    }

    public String getCompanyPostcode() {
        return companyPostcode;
    }

    public void setCompanyPostcode(String companyPostcode) {
        this.companyPostcode = companyPostcode;
    }

    public String getDirecterName() {
        return directerName;
    }

    public void setDirecterName(String directerName) {
        this.directerName = directerName;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public Byte getPhotoIdType() {
        return photoIdType;
    }

    public void setPhotoIdType(Byte photoIdType) {
        this.photoIdType = photoIdType;
    }
}
