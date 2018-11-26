package com.anole.core.domain.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class UserLoginRequest {

    /**
     * 用户名
     */
    @NotBlank(message ="{loginName.empty.error}")
    private String loginName;

    /**
     * 密码
     */
    @NotBlank(message ="{password.empty.error}")
    private String password;


}
