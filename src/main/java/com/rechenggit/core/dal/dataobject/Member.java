package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_member")
public class Member {
    /**
     * 会员ID(由seq_member_id 生成, 个人1开头，企业2开头)
     */
    @Id
    @Column(name = "MEMBER_ID")
    private String memberId;

    /**
     * 会员名称
     */
    @Column(name = "MEMBER_NAME")
    private String memberName;

    /**
     * 会员缩略名,已注销的会被添加后缀
     */
    @Column(name = "MEMBER_SHORT_NAME")
    private String memberShortName;

    /**
     * 会员类型(1个人 2 公司 3 组织)
     */
    @Column(name = "MEMBER_TYPE")
    private Integer memberType;

    /**
     * 会员状态(0未激活 1正常 2休眠 3注销)
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 会员锁定状态(0未锁定 1已锁定)
     */
    @Column(name = "LOCK_STATUS")
    private Integer lockStatus;

    /**
     * IP地址
     */
    @Column(name = "FROM_IP")
    private String fromIp;

    /**
     * 激活时间
     */
    @Column(name = "ACTIVE_TIME")
    private Date activeTime;

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
     * 备注信息
     */
    @Column(name = "MEMO")
    private String memo;

    /**
     * 安全等级
     */
    @Column(name = "SECURITY_LEVEL")
    private String securityLevel;

    /**
     * 获取会员ID(由seq_member_id 生成, 个人1开头，企业2开头)
     *
     * @return MEMBER_ID - 会员ID(由seq_member_id 生成, 个人1开头，企业2开头)
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置会员ID(由seq_member_id 生成, 个人1开头，企业2开头)
     *
     * @param memberId 会员ID(由seq_member_id 生成, 个人1开头，企业2开头)
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取会员名称
     *
     * @return MEMBER_NAME - 会员名称
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 设置会员名称
     *
     * @param memberName 会员名称
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 获取会员缩略名,已注销的会被添加后缀
     *
     * @return MEMBER_SHORT_NAME - 会员缩略名,已注销的会被添加后缀
     */
    public String getMemberShortName() {
        return memberShortName;
    }

    /**
     * 设置会员缩略名,已注销的会被添加后缀
     *
     * @param memberShortName 会员缩略名,已注销的会被添加后缀
     */
    public void setMemberShortName(String memberShortName) {
        this.memberShortName = memberShortName == null ? null : memberShortName.trim();
    }

    /**
     * 获取会员类型(1个人 2 公司 3 组织)
     *
     * @return MEMBER_TYPE - 会员类型(1个人 2 公司 3 组织)
     */
    public Integer getMemberType() {
        return memberType;
    }

    /**
     * 设置会员类型(1个人 2 公司 3 组织)
     *
     * @param memberType 会员类型(1个人 2 公司 3 组织)
     */
    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    /**
     * 获取会员状态(0未激活 1正常 2休眠 3注销)
     *
     * @return STATUS - 会员状态(0未激活 1正常 2休眠 3注销)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置会员状态(0未激活 1正常 2休眠 3注销)
     *
     * @param status 会员状态(0未激活 1正常 2休眠 3注销)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取会员锁定状态(0未锁定 1已锁定)
     *
     * @return LOCK_STATUS - 会员锁定状态(0未锁定 1已锁定)
     */
    public Integer getLockStatus() {
        return lockStatus;
    }

    /**
     * 设置会员锁定状态(0未锁定 1已锁定)
     *
     * @param lockStatus 会员锁定状态(0未锁定 1已锁定)
     */
    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**
     * 获取IP地址
     *
     * @return FROM_IP - IP地址
     */
    public String getFromIp() {
        return fromIp;
    }

    /**
     * 设置IP地址
     *
     * @param fromIp IP地址
     */
    public void setFromIp(String fromIp) {
        this.fromIp = fromIp == null ? null : fromIp.trim();
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
     * 获取备注信息
     *
     * @return MEMO - 备注信息
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注信息
     *
     * @param memo 备注信息
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取安全等级
     *
     * @return SECURITY_LEVEL - 安全等级
     */
    public String getSecurityLevel() {
        return securityLevel;
    }

    /**
     * 设置安全等级
     *
     * @param securityLevel 安全等级
     */
    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel == null ? null : securityLevel.trim();
    }
}