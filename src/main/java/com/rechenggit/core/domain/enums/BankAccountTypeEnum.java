package com.rechenggit.core.domain.enums;

/**
 * <p>银行账号卡类型</p>
 * @author fangjilue
 * @version $Id: BankAccountTypeEnum.java 11471 2012-08-20 02:58:43Z fangjilue $
 */
public enum BankAccountTypeEnum {
    DEBIT_CARD(1, "借记卡"), CREDIT_CARD(2, "信用卡"), PASSBOOK(3, "存折"), OTHER(4,"其它");

    /** 代码 */
    private final Integer   code;
    /** 信息 */
    private final String message;

    BankAccountTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static BankAccountTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (BankAccountTypeEnum item : BankAccountTypeEnum.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }

        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
