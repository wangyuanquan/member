package com.rechenggit.core.domain.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class OpenAccountInfo {
    /**
     * 会员编号
     */
    private String memberId;
    /**
     * 账户类型
     */
    private Long accountType;

    /**
     * 账户别名
     */
    private String alias;

    /**
     * 账户激活状态：1 激活，0 未激活
     */
    private Integer activateStatus;

    /**
     * 关联银行卡的Id
     */
    private String bankAccountId;

    /**
     * 外部账户标识
     */
    private String acctIdentity;

}
