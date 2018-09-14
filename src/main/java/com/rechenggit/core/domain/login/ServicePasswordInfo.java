package com.rechenggit.core.domain.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Setter
@Getter
@ToString
public class ServicePasswordInfo {
    /**
     * memberId
     */
    @NotBlank
    private String memberId;
    /**
     * operatorId
     */
    @NotBlank
    private String operatorId;
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
    /**
     * 交易密码
     */
    @NotBlank
    private String  paymentPassword;
    /**
     * 确认交易密码
     */
    @NotBlank
    private String  enterPaymentPassword;

}
