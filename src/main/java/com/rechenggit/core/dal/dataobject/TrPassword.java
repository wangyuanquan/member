package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tr_password")
public class TrPassword {
    /**
     * 主键(自增处理)
     */
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 操作员编号
     */
    @Column(name = "OPERATOR_ID")
    private String operatorId;

    /**
     * 账户ID
     */
    @Column(name = "ACCOUNT_ID")
    private String accountId;

    private String password;

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
     * wap端支付密码
     */
    @Column(name = "WAP_PASSWORD")
    private String wapPassword;

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
     * 获取账户ID
     *
     * @return ACCOUNT_ID - 账户ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 设置账户ID
     *
     * @param accountId 账户ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
     * 获取wap端支付密码
     *
     * @return WAP_PASSWORD - wap端支付密码
     */
    public String getWapPassword() {
        return wapPassword;
    }

    /**
     * 设置wap端支付密码
     *
     * @param wapPassword wap端支付密码
     */
    public void setWapPassword(String wapPassword) {
        this.wapPassword = wapPassword == null ? null : wapPassword.trim();
    }
}