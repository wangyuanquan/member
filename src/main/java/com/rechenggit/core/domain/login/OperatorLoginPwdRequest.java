package com.rechenggit.core.domain.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OperatorLoginPwdRequest{

    private String loginName;

    private Integer platFormType;

    private String username;

    private String password;




}
