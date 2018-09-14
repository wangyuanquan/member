package com.rechenggit.core.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>密码锁信息</p>
 * @author chenfei
 * @version $Id: PassWordLock.java, v 0.1 2012-12-24 下午1:43:29 cf Exp $
 */
public class PassWordLock implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -8054445288698783222L;

    /**
     * 操作员Id
     */
    private String operatorId;

    /**
     * 账户Id
     */
    private String accountId;

    /**
     * 统计开始时间
     */
    private Date countStartTime; 
    /**
     * 锁定时间
     */
    private Date lockTime;


    /**
     * 状态 0无效 ，1有效
     */
    private int status;


    /**
     * 所属标志（0登录密码，1支付密码）
     */
    private int flag;


    private String createUser;


    private Date createTime;


    private String updateUser;


    private Date updateTime;


    private String memo;


    public String getOperatorId() {
        return operatorId;
    }


    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }


    public String getAccountId() {
        return accountId;
    }


    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    public Date getCountStartTime() {
        return countStartTime;
    }


    public void setCountStartTime(Date countStartTime) {
        this.countStartTime = countStartTime;
    }


    public Date getLockTime() {
        return lockTime;
    }


    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }


    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    public int getFlag() {
        return flag;
    }


    public void setFlag(int flag) {
        this.flag = flag;
    }


    public String getCreateUser() {
        return createUser;
    }


    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getUpdateUser() {
        return updateUser;
    }


    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getMemo() {
        return memo;
    }


    public void setMemo(String memo) {
        this.memo = memo;
    }
    

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }    
}
