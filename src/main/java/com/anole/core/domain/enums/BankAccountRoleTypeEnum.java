package com.anole.core.domain.enums;

/**
 * <p>会员角色类型</p>
 * @author lifuze
 * @version $Id: BankAccountRoleTypeEnum.java 2014-09-16 lifuze $
 */
public enum BankAccountRoleTypeEnum {
    SELLER(1, "卖家"), MARKETER(2, "推广者");

    /** 代码 */
    private final Integer   code;
    /** 信息 */
    private final String message;

    BankAccountRoleTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static BankAccountRoleTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (BankAccountRoleTypeEnum item : BankAccountRoleTypeEnum.values()) {
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
