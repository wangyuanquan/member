package com.anole.core.dal.dataobject;

import javax.persistence.*;

@Table(name = "cm_user_info")
public class UserInfo {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "login_password")
    private String loginPassword;

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
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return login_name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * @return login_password
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * @param loginPassword
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }
}