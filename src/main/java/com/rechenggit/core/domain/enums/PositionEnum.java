package com.rechenggit.core.domain.enums;

/**
 * <p>职位类型枚举</p>
 * @author netfinworks
 * @version $Id: PositionEnum.java 24517 2012-11-16 06:31:05Z malianhao $
 */
public enum PositionEnum {
    DEFAULT(1L, "默认职位");

    /** 代码 */
    private final Long   code;
    /** 信息 */
    private final String message;

    PositionEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static PositionEnum getByCode(Long code) {
        if (code == null) {
            return null;
        }

        for (PositionEnum pe : PositionEnum.values()) {
            if (pe.getCode().equals(code)) {
                return pe;
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
