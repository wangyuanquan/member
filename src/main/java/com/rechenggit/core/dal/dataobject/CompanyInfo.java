package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_company_info")
public class CompanyInfo {
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
     * 公司注册：名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司注册支持票据（ABN）
     */
    @Column(name = "company_abn")
    private String companyAbn;

    /**
     * 公司注册：税号（ACN）
     */
    @Column(name = "company_acn")
    private String companyAcn;

    /**
     * 公司注册：行业
     */
    @Column(name = "company_industry")
    private String companyIndustry;

    /**
     * 公司注册：地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 注册地址：市郊
     */
    @Column(name = "company_suburb")
    private String companySuburb;

    /**
     * 注册地址：州
     */
    @Column(name = "company_state")
    private String companyState;

    /**
     * 注册地址：邮政编码
     */
    @Column(name = "company_postcode")
    private String companyPostcode;

    /**
     * 注册信息：直接名称
     */
    @Column(name = "directer_name")
    private String directerName;

    /**
     * 图片（照片，执照，驾照）
     */
    @Column(name = "photo_id")
    private String photoId;

    /**
     * 图片类型
     */
    @Column(name = "photo_id_type")
    private Byte photoIdType;

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
     * 获取公司注册：名称
     *
     * @return company_name - 公司注册：名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司注册：名称
     *
     * @param companyName 公司注册：名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取公司注册支持票据（ABN）
     *
     * @return company_abn - 公司注册支持票据（ABN）
     */
    public String getCompanyAbn() {
        return companyAbn;
    }

    /**
     * 设置公司注册支持票据（ABN）
     *
     * @param companyAbn 公司注册支持票据（ABN）
     */
    public void setCompanyAbn(String companyAbn) {
        this.companyAbn = companyAbn == null ? null : companyAbn.trim();
    }

    /**
     * 获取公司注册：税号（ACN）
     *
     * @return company_acn - 公司注册：税号（ACN）
     */
    public String getCompanyAcn() {
        return companyAcn;
    }

    /**
     * 设置公司注册：税号（ACN）
     *
     * @param companyAcn 公司注册：税号（ACN）
     */
    public void setCompanyAcn(String companyAcn) {
        this.companyAcn = companyAcn == null ? null : companyAcn.trim();
    }

    /**
     * 获取公司注册：行业
     *
     * @return company_industry - 公司注册：行业
     */
    public String getCompanyIndustry() {
        return companyIndustry;
    }

    /**
     * 设置公司注册：行业
     *
     * @param companyIndustry 公司注册：行业
     */
    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry == null ? null : companyIndustry.trim();
    }

    /**
     * 获取公司注册：地址
     *
     * @return company_address - 公司注册：地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置公司注册：地址
     *
     * @param companyAddress 公司注册：地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    /**
     * 获取注册地址：市郊
     *
     * @return company_suburb - 注册地址：市郊
     */
    public String getCompanySuburb() {
        return companySuburb;
    }

    /**
     * 设置注册地址：市郊
     *
     * @param companySuburb 注册地址：市郊
     */
    public void setCompanySuburb(String companySuburb) {
        this.companySuburb = companySuburb == null ? null : companySuburb.trim();
    }

    /**
     * 获取注册地址：州
     *
     * @return company_state - 注册地址：州
     */
    public String getCompanyState() {
        return companyState;
    }

    /**
     * 设置注册地址：州
     *
     * @param companyState 注册地址：州
     */
    public void setCompanyState(String companyState) {
        this.companyState = companyState == null ? null : companyState.trim();
    }

    /**
     * 获取注册地址：邮政编码
     *
     * @return company_postcode - 注册地址：邮政编码
     */
    public String getCompanyPostcode() {
        return companyPostcode;
    }

    /**
     * 设置注册地址：邮政编码
     *
     * @param companyPostcode 注册地址：邮政编码
     */
    public void setCompanyPostcode(String companyPostcode) {
        this.companyPostcode = companyPostcode == null ? null : companyPostcode.trim();
    }

    /**
     * 获取注册信息：直接名称
     *
     * @return directer_name - 注册信息：直接名称
     */
    public String getDirecterName() {
        return directerName;
    }

    /**
     * 设置注册信息：直接名称
     *
     * @param directerName 注册信息：直接名称
     */
    public void setDirecterName(String directerName) {
        this.directerName = directerName == null ? null : directerName.trim();
    }

    /**
     * 获取图片（照片，执照，驾照）
     *
     * @return photo_id - 图片（照片，执照，驾照）
     */
    public String getPhotoId() {
        return photoId;
    }

    /**
     * 设置图片（照片，执照，驾照）
     *
     * @param photoId 图片（照片，执照，驾照）
     */
    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    /**
     * 获取图片类型
     *
     * @return photo_id_type - 图片类型
     */
    public Byte getPhotoIdType() {
        return photoIdType;
    }

    /**
     * 设置图片类型
     *
     * @param photoIdType 图片类型
     */
    public void setPhotoIdType(Byte photoIdType) {
        this.photoIdType = photoIdType;
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