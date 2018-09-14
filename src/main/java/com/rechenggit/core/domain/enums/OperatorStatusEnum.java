package com.rechenggit.core.domain.enums;

/**
 * <p>操作员状态枚举</p>
 * @author netfinworks
 * @version $Id: OperatorStatusEnum.java 24517 2012-11-16 06:31:05Z malianhao $
 */
public enum OperatorStatusEnum {
    UNACTIVE(0, "未激活"), NORMAL(1, "正常"), CANCEL(2, "注销");

    /** 代码 */
    private final Integer   code;
    /** 信息 */
    private final String message;

    OperatorStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static OperatorStatusEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (OperatorStatusEnum ose : OperatorStatusEnum.values()) {
            if (ose.getCode().equals(code)) {
                return ose;
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
