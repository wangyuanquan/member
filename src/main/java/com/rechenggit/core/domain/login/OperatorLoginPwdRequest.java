package com.rechenggit.core.domain.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
@ToString
public class OperatorLoginPwdRequest{

    @NotEmpty(message = "{identity.empty.error}")
    private String identity;
    private Integer platFormType;

    private String loginName;
    @NotEmpty(message = "{login.password.empty.error}")
    private String password;




}
