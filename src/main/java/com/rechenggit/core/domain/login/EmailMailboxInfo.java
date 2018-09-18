package com.rechenggit.core.domain.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Setter
@Getter
@ToString
public class EmailMailboxInfo {
    /**
     * 商户邮箱
     */
    @NotBlank
    @Email
    private String email;
    /**
     * 激活码
     */
    @NotBlank
    private String code;


}
