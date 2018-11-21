package com.anole.core.domain.enums;

/**
 * <p>联系信息类型枚举</p>
 * @author netfinworks
 * @version $Id: ContactTypeEnum.java 33340 2013-01-09 11:03:48Z fangjilue $
 */
public enum ContactTypeEnum {
    MEMBER(0L, "会员联系信息"),
    OPERATOR(1L, "操作员联系信息")
    ;

    /** 代码 */
    private final Long   code;
    /** 信息 */
    private final String message;

    ContactTypeEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static ContactTypeEnum getByCode(Long code) {
        if (code == null) {
            return null;
        }

        for (ContactTypeEnum ce : ContactTypeEnum.values()) {
            if (ce.getCode().equals(code)) {
                return ce;
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
