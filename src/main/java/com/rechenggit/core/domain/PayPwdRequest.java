package com.rechenggit.core.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>做退款</p>
 *
 * @author renxiaohu
 * @version v 1.0
 * @create 2018-07-20 下午4:27
 */
@Getter
@Setter
@ToString
public class PayPwdRequest {

    private String operatorId; // 操作员ID
    private String memberId; // 会员ID
    private String payPassword;
}
