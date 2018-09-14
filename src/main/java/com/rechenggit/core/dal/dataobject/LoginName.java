package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tr_login_name")
public class LoginName {
    /**
     * 主键(自增处理)
     */
    @Id
    @Column(name = "login_id")
    private Integer loginId;

    /**
     * 会员ID
     */
    @Column(name = "MEMBER_ID")
    private String memberId;

    /**
     * 操作员编号
     */
    @Column(name = "OPERATOR_ID")
    private String operatorId;

    /**
     * 登录名
     */
    @Column(name = "LOGIN_NAME")
    private String loginName;

    /**
     * 来源类型(0微汇通行证)
     */
    @Column(name = "SOURCE_TYPE")
    private Integer sourceType;

    /**
     * 登录名类型(0微汇通行证 1邮箱 2手机)
     */
    @Column(name = "LOGIN_NAME_TYPE")
    private Integer loginNameType;

    /**
     * 唯一编号
     */
    @Column(name = "UUID")
    private String uuid;

    /**
     * 建立时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 建立人
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 更新人
     */
    @Column(name = "UPDATE_USER")
    private String updateUser;

    /**
     * 备注
     */
    @Column(name = "MEMO")
    private String memo;

    /**
     * 获取主键(自增处理)
     *
     * @return login_id - 主键(自增处理)
     */
    public Integer getLoginId() {
        return loginId;
    }

    /**
     * 设置主键(自增处理)
     *
     * @param loginId 主键(自增处理)
     */
    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    /**
     * 获取会员ID
     *
     * @return MEMBER_ID - 会员ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置会员ID
     *
     * @param memberId 会员ID
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取操作员编号
     *
     * @return OPERATOR_ID - 操作员编号
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作员编号
     *
     * @param operatorId 操作员编号
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * 获取登录名
     *
     * @return LOGIN_NAME - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取来源类型(0微汇通行证)
     *
     * @return SOURCE_TYPE - 来源类型(0微汇通行证)
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     * 设置来源类型(0微汇通行证)
     *
     * @param sourceType 来源类型(0微汇通行证)
     */
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 获取登录名类型(0微汇通行证 1邮箱 2手机)
     *
     * @return LOGIN_NAME_TYPE - 登录名类型(0微汇通行证 1邮箱 2手机)
     */
    public Integer getLoginNameType() {
        return loginNameType;
    }

    /**
     * 设置登录名类型(0微汇通行证 1邮箱 2手机)
     *
     * @param loginNameType 登录名类型(0微汇通行证 1邮箱 2手机)
     */
    public void setLoginNameType(Integer loginNameType) {
        this.loginNameType = loginNameType;
    }

    /**
     * 获取唯一编号
     *
     * @return UUID - 唯一编号
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置唯一编号
     *
     * @param uuid 唯一编号
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * 获取建立时间
     *
     * @return CREATE_TIME - 建立时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置建立时间
     *
     * @param createTime 建立时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
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
     * 获取建立人
     *
     * @return CREATE_USER - 建立人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置建立人
     *
     * @param createUser 建立人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 获取更新人
     *
     * @return UPDATE_USER - 更新人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新人
     *
     * @param updateUser 更新人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 获取备注
     *
     * @return MEMO - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}