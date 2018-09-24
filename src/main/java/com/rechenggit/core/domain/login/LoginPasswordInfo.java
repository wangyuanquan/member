package com.rechenggit.core.domain.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
@ToString
public class LoginPasswordInfo {
    /**
     * memberId
     */
    @NotBlank(message ="{memberId.empty.error}")
    private String memberId;
    /**
     * operatorId
     */
    @NotBlank(message ="{operatorId.empty.error}")
    private String operatorId;
    /**
     * 原密码
     */
    @NotBlank
    private String oldPassword;
    /**
     * 登录密码
     */
    @NotBlank
    private String loginPassword;
    /**
     * 确认登录密码
     */
    @NotBlank
    private String  enterLoginPassword;


}
