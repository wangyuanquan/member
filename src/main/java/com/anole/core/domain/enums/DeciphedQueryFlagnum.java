package com.anole.core.domain.enums;


/**
 * <p>解密返回数据标志枚举</p>
 * @author chenfei
 * @version $Id: DeciphedQueryFlagnum.java, v 0.1 2013-1-29 下午3:32:32 cf Exp $
 */
public enum DeciphedQueryFlagnum {
    ALL(0, "明文与ticket"),
    PRIMITIVE(1, "明文"),
    TICKET(2, "加密后ticket"),
    ;

    /** 代码 */
    private final Integer   code;
    /** 信息 */
    private final String message;

    DeciphedQueryFlagnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static DeciphedQueryFlagnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (DeciphedQueryFlagnum ce : DeciphedQueryFlagnum.values()) {
            if (ce.getCode().equals(code)) {
                return ce;
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
