package com.rechenggit.core.domain.enums;

/**
 * <p>银行账号查询条件枚举</p>
 * @author fangjilue
 * @version $Id: BankAccountConditionEnum.java 11471 2012-08-20 02:58:43Z fangjilue $
 */
public enum BankAccountConditionEnum {
    ALL(0, "全部"), QUICK_CARD(1, "快捷卡");

    /** 代码 */
    private final Integer code;
    /** 信息 */
    private final String  message;

    BankAccountConditionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static BankAccountConditionEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (BankAccountConditionEnum item : BankAccountConditionEnum.values()) {
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
