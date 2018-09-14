package com.rechenggit.core.domain.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OperatorLoginPwdRequest{

    private String identity;

    private Integer platFormType;

    private String loginName;

    private String password;




}
