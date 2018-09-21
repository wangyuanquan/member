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
    private Long settlementCycle;

    /**
     * 对商人费率
     */
    private Long merchant;

    /**
     * 对消费者费率
     */
    private Long consumer;

    /**
     * 结算服务类型
     */
    private Long settlementType;


}
