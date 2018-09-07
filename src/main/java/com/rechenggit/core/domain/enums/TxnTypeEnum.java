/**
 * 
 */
package com.rechenggit.core.domain.enums;

/**
 * <p>账户余额明细查询交易类型</p>
 * @author netfinworks
 * @version $Id: TxnTypeEnum.java 11471 2012-08-20 02:58:43Z fangjilue $
 */
public enum TxnTypeEnum {

    ALL(1, "所有"), PAYOUT(2, "支出"), INCOME(3, "收入");

    private final Integer code;
    private final String  displayName;

    TxnTypeEnum(Integer code, String displayName) {
        this.code = code;
        this.displayName = displayName;

    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static TxnTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (TxnTypeEnum txn : TxnTypeEnum.values()) {
            if (txn.getCode().equals(code)) {
                return txn;
            }
        }

        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }
}
