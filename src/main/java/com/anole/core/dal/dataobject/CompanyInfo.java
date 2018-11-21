package com.anole.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_company_info")
public class CompanyInfo {
    @Id
    private Integer id;

    /**
     * 商户ID
     */
    @Column(name = "member_id")
    private String memberId;

    /**
     * 页面展示序号
     */
    @Column(name = "display_num")
    private Byte displayNum;

    /**
     * 注册信息-经理姓名
     */
    @Column(name = "directer_name")
    private String directerName;

    /**
     * 证件ID
     */
    @Column(name = "photo_id")
    private String photoId;

    /**
     * 证件类型:1=照片,2=执照,3=驾照,0=其他
     */
    @Column(name = "photo_id_type")
    private Byte photoIdType;

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
     * 获取商户ID
     *
     * @return member_id - 商户ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置商户ID
     *
     * @param memberId 商户ID
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
     * 获取注册信息-经理姓名
     *
     * @return directer_name - 注册信息-经理姓名
     */
    public String getDirecterName() {
        return directerName;
    }

    /**
     * 设置注册信息-经理姓名
     *
     * @param directerName 注册信息-经理姓名
     */
    public void setDirecterName(String directerName) {
        this.directerName = directerName == null ? null : directerName.trim();
    }

    /**
     * 获取证件ID
     *
     * @return photo_id - 证件ID
     */
    public String getPhotoId() {
        return photoId;
    }

    /**
     * 设置证件ID
     *
     * @param photoId 证件ID
     */
    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    /**
     * 获取证件类型:1=照片,2=执照,3=驾照,0=其他
     *
     * @return photo_id_type - 证件类型:1=照片,2=执照,3=驾照,0=其他
     */
    public Byte getPhotoIdType() {
        return photoIdType;
    }

    /**
     * 设置证件类型:1=照片,2=执照,3=驾照,0=其他
     *
     * @param photoIdType 证件类型:1=照片,2=执照,3=驾照,0=其他
     */
    public void setPhotoIdType(Byte photoIdType) {
        this.photoIdType = photoIdType;
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
}