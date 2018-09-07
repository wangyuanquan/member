package com.rechenggit.core.domain.enums;

/**
 * 
 * <p>登录密码验证规则</p>
 * @author fjl
 * @version $Id: ValidateLoginPwdModeEnum.java 38102 2013-03-07 05:03:39Z fangjilue $
 */
public enum ValidateLoginPwdModeEnum {
    CHECK_SET_LOCKED(0, "检查登录密码是否设置与锁定"),
    IS_SET(1, "检查登录密码是否已设置"),
    LOCKED(2, "检查登录密码是否被锁定");

    private final Integer code;
    private final String  message;

    ValidateLoginPwdModeEnum(Integer code, String message) {
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
    public static ValidateLoginPwdModeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (ValidateLoginPwdModeEnum type : ValidateLoginPwdModeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }
}
