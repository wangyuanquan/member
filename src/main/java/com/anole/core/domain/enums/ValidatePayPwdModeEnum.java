package com.anole.core.domain.enums;

/**
 * 
 * <p>支付密码验证规则</p>
 * @author fjl
 * @version $Id: ValidatePayPwdModeEnum.java 38102 2013-03-07 05:03:39Z fangjilue $
 */
public enum ValidatePayPwdModeEnum {
    CHECK_SET_LOCKED(0, "检查支付密码是否设置与锁定"),
    IS_SET(1, "检查支付密码是否已设置"),
    LOCKED(2, "检查支付密码是否被锁定");

    private final Integer code;
    private final String  message;

    ValidatePayPwdModeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static ValidatePayPwdModeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (ValidatePayPwdModeEnum type : ValidatePayPwdModeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }
}
