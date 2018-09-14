package com.rechenggit.core.dal.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tm_member_identity")
public class MemberIdentity {
    /**
     * 会员标识
     */
    @Id
    @Column(name = "IDENTITY")
    private String identity;

    /**
     * 会员编号
     */
    @Column(name = "MEMBER_ID")
    private String memberId;

    /**
     * 1：有效；0：无效
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 1：可以作为收款标识；0：不可以作为收款标识
     */
    @Column(name = "IS_RECV_ADDR")
    private Integer isRecvAddr;

    /**
     * 标识类型（0：uid 1：邮箱 2:手机）
     */
    @Column(name = "IDENTITY_TYPE")
    private Integer identityType;

    /**
     * 建立时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 备注
     */
    @Column(name = "MEMO")
    private String memo;

    /**
     * 平台类型：1:个人 2：企业
     */
    @Column(name = "PID")
    private Integer pid;

    /**
     * 获取会员标识
     *
     * @return IDENTITY - 会员标识
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * 设置会员标识
     *
     * @param identity 会员标识
     */
    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    /**
     * 获取会员编号
     *
     * @return MEMBER_ID - 会员编号
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置会员编号
     *
     * @param memberId 会员编号
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取1：有效；0：无效
     *
     * @return STATUS - 1：有效；0：无效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1：有效；0：无效
     *
     * @param status 1：有效；0：无效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取1：可以作为收款标识；0：不可以作为收款标识
     *
     * @return IS_RECV_ADDR - 1：可以作为收款标识；0：不可以作为收款标识
     */
    public Integer getIsRecvAddr() {
        return isRecvAddr;
    }

    /**
     * 设置1：可以作为收款标识；0：不可以作为收款标识
     *
     * @param isRecvAddr 1：可以作为收款标识；0：不可以作为收款标识
     */
    public void setIsRecvAddr(Integer isRecvAddr) {
        this.isRecvAddr = isRecvAddr;
    }

    /**
     * 获取标识类型（0：uid 1：邮箱 2:手机）
     *
     * @return IDENTITY_TYPE - 标识类型（0：uid 1：邮箱 2:手机）
     */
    public Integer getIdentityType() {
        return identityType;
    }

    /**
     * 设置标识类型（0：uid 1：邮箱 2:手机）
     *
     * @param identityType 标识类型（0：uid 1：邮箱 2:手机）
     */
    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
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
     * 获取修改时间
     *
     * @return UPDATE_TIME - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
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

    /**
     * 获取平台类型：1:个人 2：企业
     *
     * @return PID - 平台类型：1:个人 2：企业
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置平台类型：1:个人 2：企业
     *
     * @param pid 平台类型：1:个人 2：企业
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}