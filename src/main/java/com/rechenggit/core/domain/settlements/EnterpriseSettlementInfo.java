package com.rechenggit.core.domain.settlements;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Setter
@Getter
@ToString
public class EnterpriseSettlementInfo {

    /**
     * 商家id
     */
    private String memberId;

    /**
     * 结算周期
     */
    private Integer settlementCycle;

    /**
     * 对商人费率
     */
    private Float merchant;

    /**
     * 对消费者费率
     */
    private Float consumer;

    /**
     * 结算服务类型
     */
    private Integer settlementType;
    /**
     * 商户名称
     */
    private String memberName;
    /**
     * 用户名
     */
    private String accountName;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * bsb账号
     */
    private String bbsNumber;


}
