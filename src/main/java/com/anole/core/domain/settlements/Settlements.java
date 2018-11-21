package com.anole.core.domain.settlements;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class Settlements {

    /**
     * 微信
     */
    @NotBlank(message ="{weChat.empty.error}")
    private BigDecimal weChat;

    /**
     * 支付宝
     */
    @NotBlank(message ="{alipay.empty.error}")
    private BigDecimal alipay;

    /**
     * 结算服务类型
     */
    @NotBlank(message ="{settlementType.empty.error}")
    private Integer settlementType;

}
