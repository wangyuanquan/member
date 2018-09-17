package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_mailbox_activation")
public class MailboxActivation {
    @Id
    private Integer id;

    @Column(name = "member_id")
    private String memberId;

    /**
     * 用户邮箱
     */
    @Column(name = "mailbox_name")
    private String mailboxName;

    /**
     * 用户激活码
     */
    @Column(name = "activation_code")
    private String activationCode;

    /**
     * 用户激活状态(0:未激活1:已激活)
     */
    private Integer status;

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
     * 获取用户邮箱
     *
     * @return mailbox_name - 用户邮箱
     */
    public String getMailboxName() {
        return mailboxName;
    }

    /**
     * 设置用户邮箱
     *
     * @param mailboxName 用户邮箱
     */
    public void setMailboxName(String mailboxName) {
        this.mailboxName = mailboxName == null ? null : mailboxName.trim();
    }

    /**
     * 获取用户激活码
     *
     * @return activation_code - 用户激活码
     */
    public String getActivationCode() {
        return activationCode;
    }

    /**
     * 设置用户激活码
     *
     * @param activationCode 用户激活码
     */
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode == null ? null : activationCode.trim();
    }

    /**
     * 获取用户激活状态(0:未激活1:已激活)
     *
     * @return status - 用户激活状态(0:未激活1:已激活)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户激活状态(0:未激活1:已激活)
     *
     * @param status 用户激活状态(0:未激活1:已激活)
     */
    public void setStatus(Integer status) {
        this.status = status;
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