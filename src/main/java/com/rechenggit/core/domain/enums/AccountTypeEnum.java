package com.rechenggit.core.domain.enums;


/**
 * <p>账户类型枚举</p>
 * @author chenfei
 * @version $Id: AccountTypeEnum.java, v 0.1 2013-1-29 下午3:18:24 cf Exp $
 */
public enum AccountTypeEnum {
    TO_PRIVATE_BASE(101L, "对私基本户"), 
    TO_PRIVATE_SPECIAL(103L, "对私专用户"),
    TO_COMMON_BASE(201L, "对公基本户"), ;

    /** 代码 */
    private final Long   code;
    /** 信息 */
    private final String message;

    AccountTypeEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static AccountTypeEnum getByCode(Long code) {
        if (code == null) {
            return null;
        }

        for (AccountTypeEnum le : AccountTypeEnum.values()) {
            if (le.getCode().equals(code)) {
                return le;
            }
        }

        return null;
    }

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
