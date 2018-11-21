package com.anole.core.domain.settlements;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Setter
@Getter
@ToString
public class EnterpriseSettlementInfo {

    /**
     * 商家id
     */
    @NotBlank(message ="{memberId.empty.error}")
    private String memberId;
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
    /**
     * 结算周期
     */
    private String settlementCycle;
    /**
     * 结算信息
     */
    private List<Settlements> settlements;
}
