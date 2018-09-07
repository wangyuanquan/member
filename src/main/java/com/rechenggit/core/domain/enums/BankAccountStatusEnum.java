package com.rechenggit.core.domain.enums;

/**
 * <p>银行账号状态枚举</p>
 * @author netfinworks
 * @version $Id: BankAccountStatusEnum.java, v 0.1 2010-11-26 下午05:21:24 netfinworks Exp $
 */
public enum BankAccountStatusEnum {
    DISABLED(0, "无效"), NORMAL(1, "正常"), LOCKED(2, "锁定"), UNACTIVE(3, "未激活");

    /** 代码 */
    private final Integer code;
    /** 信息 */
    private final String  message;

    BankAccountStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static BankAccountStatusEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (BankAccountStatusEnum statusEnum : BankAccountStatusEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
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
