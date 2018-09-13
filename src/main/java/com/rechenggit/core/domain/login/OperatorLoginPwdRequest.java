package com.rechenggit.core.domain.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OperatorLoginPwdRequest{

    private String email;

    private String username;

    private String password;

    /**
     * 闲值
     */
    private String  salt;

}
