package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_pwd_operator_lock")
public class PwdOperatorLock {
    /**
     * 主键(自增处理)
     */
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 操作员ID
     */
    @Column(name = "OPERATOR_ID")
    private String operatorId;

    /**
     * 账号ID
     */
    @Column(name = "ACCOUNT_ID")
    private String accountId;

    /**
     * 开始统计错误次数的起始时间点
     */
    @Column(name = "COUNT_START_TIME")
    private Date countStartTime;

    /**
     * 被锁定时间点(null:未被锁定)
     */
    @Column(name = "LOCK_TIME")
    private Date lockTime;

    /**
     * 状态（0无效 ，1有效）
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 所属标志（0登录密码，1支付密码）
     */
    @Column(name = "FLAG")
    private Integer flag;

    /**
     * 创建用户
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 建立时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 更新用户
     */
    @Column(name = "UPDATE_USER")
    private String updateUser;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 备注
     */
    @Column(name = "MEMO")
    private String memo;

    /**
     * 获取主键(自增处理)
     *
     * @return ID - 主键(自增处理)
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键(自增处理)
     *
     * @param id 主键(自增处理)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取操作员ID
     *
     * @return OPERATOR_ID - 操作员ID
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作员ID
     *
     * @param operatorId 操作员ID
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * 获取账号ID
     *
     * @return ACCOUNT_ID - 账号ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 设置账号ID
     *
     * @param accountId 账号ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 获取开始统计错误次数的起始时间点
     *
     * @return COUNT_START_TIME - 开始统计错误次数的起始时间点
     */
    public Date getCountStartTime() {
        return countStartTime;
    }

    /**
     * 设置开始统计错误次数的起始时间点
     *
     * @param countStartTime 开始统计错误次数的起始时间点
     */
    public void setCountStartTime(Date countStartTime) {
        this.countStartTime = countStartTime;
    }

    /**
     * 获取被锁定时间点(null:未被锁定)
     *
     * @return LOCK_TIME - 被锁定时间点(null:未被锁定)
     */
    public Date getLockTime() {
        return lockTime;
    }

    /**
     * 设置被锁定时间点(null:未被锁定)
     *
     * @param lockTime 被锁定时间点(null:未被锁定)
     */
    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    /**
     * 获取状态（0无效 ，1有效）
     *
     * @return STATUS - 状态（0无效 ，1有效）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（0无效 ，1有效）
     *
     * @param status 状态（0无效 ，1有效）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取所属标志（0登录密码，1支付密码）
     *
     * @return FLAG - 所属标志（0登录密码，1支付密码）
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置所属标志（0登录密码，1支付密码）
     *
     * @param flag 所属标志（0登录密码，1支付密码）
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取创建用户
     *
     * @return CREATE_USER - 创建用户
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建用户
     *
     * @param createUser 创建用户
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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
     * 获取更新用户
     *
     * @return UPDATE_USER - 更新用户
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新用户
     *
     * @param updateUser 更新用户
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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