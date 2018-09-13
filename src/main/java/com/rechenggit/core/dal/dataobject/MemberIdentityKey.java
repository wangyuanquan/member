package com.rechenggit.core.dal.dataobject;

import javax.persistence.*;

@Table(name = "tm_member_identity")
public class MemberIdentityKey {
    /**
     * 会员标识
     */
    @Id
    @Column(name = "IDENTITY")
    private String identity;

    /**
     * 平台类型：1：uid 2：手机号 3：登录名
     */
    @Id
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
     * 获取平台类型：1：uid 2：手机号 3：登录名
     *
     * @return PID - 平台类型：1：uid 2：手机号 3：登录名
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置平台类型：1：uid 2：手机号 3：登录名
     *
     * @param pid 平台类型：1：uid 2：手机号 3：登录名
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}