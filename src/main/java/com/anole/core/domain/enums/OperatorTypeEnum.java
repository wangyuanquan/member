package com.anole.core.domain.enums;

/**
 * <p>操作员类型枚举</p>
 * @author netfinworks
 * @version $Id: OperatorTypeEnum.java 24517 2012-11-16 06:31:05Z malianhao $
 */
public enum OperatorTypeEnum {
    PERSONAL(1L, "个人"), COMPANY(2L, "企业"), INSTITUTION(3L, "非企业机构"), PER_MERCHANT(4L, "个人商户");

    /** 代码 */
    private final Long   code;
    /** 信息 */
    private final String message;

    OperatorTypeEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static OperatorTypeEnum getByCode(Long code) {
        if (code == null) {
            return null;
        }

        for (OperatorTypeEnum ot : OperatorTypeEnum.values()) {
            if (ot.getCode().equals(code)) {
                return ot;
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
