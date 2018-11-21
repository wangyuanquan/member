package com.anole.core.domain.enums;

/**
 * <p>登录名类型类型枚举</p>
 * @author netfinworks
 * @version $Id: LoginNameTypeEnum.java, v 0.1 2010-11-29 下午02:17:45 netfinworks Exp $
 */
public enum VerifyTypeEnum {
    CELL_PHONE(11, "手机号"),
    EMAIL(12, "邮箱");
    

    /** 代码 */
    private final Integer   code;
    /** 信息 */
    private final String message;

    VerifyTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static VerifyTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (VerifyTypeEnum lnt : VerifyTypeEnum.values()) {
            if (lnt.getCode().equals(code)) {
                return lnt;
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
