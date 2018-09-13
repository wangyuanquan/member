package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_operator")
public class Operator {
    /**
     * 操作员编号(由seq_operator_id 生成,并以7开头)
     */
    @Id
    @Column(name = "OPERATOR_ID")
    private String operatorId;

    /**
     * 会员ID
     */
    @Column(name = "MEMBER_ID")
    private String memberId;

    /**
     * 昵称
     */
    @Column(name = "NICKNAME")
    private String nickname;

    /**
     * 操作员类型(1个人 2企业)
     */
    @Column(name = "OPERATOR_TYPE")
    private Integer operatorType;

    /**
     * 是否为默认操作员(0 否 1是)
     */
    @Column(name = "IS_DEFAULT")
    private Integer isDefault;

    /**
     * 状态(0未激活 1正常  3注销)
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 激活时间
     */
    @Column(name = "ACTIVE_TIME")
    private Date activeTime;

    /**
     * 锁定状态(0未锁定 1已锁定)
     */
    @Column(name = "LOCK_STATUS")
    private Integer lockStatus;

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
     * 安全等级标记 0：默认无  1：数字证书
     */
    @Column(name = "SECURITY_FLAG")
    private Integer securityFlag;

    /**
     * 登录密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 手势密码
     */
    @Column(name = "GESTURE_PWD")
    private String gesturePwd;

    /**
     * 头像URL
     */
    @Column(name = "FACE_MARK_URL")
    private String faceMarkUrl;

    /**
     * 防伪信息
     */
    @Column(name = "ANTI_FAKE_MARK")
    private String antiFakeMark;

    /**
     * 获取操作员编号(由seq_operator_id 生成,并以7开头)
     *
     * @return OPERATOR_ID - 操作员编号(由seq_operator_id 生成,并以7开头)
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作员编号(由seq_operator_id 生成,并以7开头)
     *
     * @param operatorId 操作员编号(由seq_operator_id 生成,并以7开头)
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
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
     * 获取昵称
     *
     * @return NICKNAME - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取操作员类型(1个人 2企业)
     *
     * @return OPERATOR_TYPE - 操作员类型(1个人 2企业)
     */
    public Integer getOperatorType() {
        return operatorType;
    }

    /**
     * 设置操作员类型(1个人 2企业)
     *
     * @param operatorType 操作员类型(1个人 2企业)
     */
    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    /**
     * 获取是否为默认操作员(0 否 1是)
     *
     * @return IS_DEFAULT - 是否为默认操作员(0 否 1是)
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否为默认操作员(0 否 1是)
     *
     * @param isDefault 是否为默认操作员(0 否 1是)
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取状态(0未激活 1正常  3注销)
     *
     * @return STATUS - 状态(0未激活 1正常  3注销)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(0未激活 1正常  3注销)
     *
     * @param status 状态(0未激活 1正常  3注销)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取激活时间
     *
     * @return ACTIVE_TIME - 激活时间
     */
    public Date getActiveTime() {
        return activeTime;
    }

    /**
     * 设置激活时间
     *
     * @param activeTime 激活时间
     */
    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    /**
     * 获取锁定状态(0未锁定 1已锁定)
     *
     * @return LOCK_STATUS - 锁定状态(0未锁定 1已锁定)
     */
    public Integer getLockStatus() {
        return lockStatus;
    }

    /**
     * 设置锁定状态(0未锁定 1已锁定)
     *
     * @param lockStatus 锁定状态(0未锁定 1已锁定)
     */
    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
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

    /**
     * 获取安全等级标记 0：默认无  1：数字证书
     *
     * @return SECURITY_FLAG - 安全等级标记 0：默认无  1：数字证书
     */
    public Integer getSecurityFlag() {
        return securityFlag;
    }

    /**
     * 设置安全等级标记 0：默认无  1：数字证书
     *
     * @param securityFlag 安全等级标记 0：默认无  1：数字证书
     */
    public void setSecurityFlag(Integer securityFlag) {
        this.securityFlag = securityFlag;
    }

    /**
     * 获取登录密码
     *
     * @return PASSWORD - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取手势密码
     *
     * @return GESTURE_PWD - 手势密码
     */
    public String getGesturePwd() {
        return gesturePwd;
    }

    /**
     * 设置手势密码
     *
     * @param gesturePwd 手势密码
     */
    public void setGesturePwd(String gesturePwd) {
        this.gesturePwd = gesturePwd == null ? null : gesturePwd.trim();
    }

    /**
     * 获取头像URL
     *
     * @return FACE_MARK_URL - 头像URL
     */
    public String getFaceMarkUrl() {
        return faceMarkUrl;
    }

    /**
     * 设置头像URL
     *
     * @param faceMarkUrl 头像URL
     */
    public void setFaceMarkUrl(String faceMarkUrl) {
        this.faceMarkUrl = faceMarkUrl == null ? null : faceMarkUrl.trim();
    }

    /**
     * 获取防伪信息
     *
     * @return ANTI_FAKE_MARK - 防伪信息
     */
    public String getAntiFakeMark() {
        return antiFakeMark;
    }

    /**
     * 设置防伪信息
     *
     * @param antiFakeMark 防伪信息
     */
    public void setAntiFakeMark(String antiFakeMark) {
        this.antiFakeMark = antiFakeMark == null ? null : antiFakeMark.trim();
    }
}