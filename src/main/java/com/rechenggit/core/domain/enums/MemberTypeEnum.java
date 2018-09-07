package com.rechenggit.core.domain.enums;

/**
 * <p>会员类型枚举</p>
 * @author netfinworks
 * @version $Id: MemberTypeEnum.java 33158 2013-01-08 10:31:39Z fangjilue $
 */
public enum MemberTypeEnum {
    PERSONAL(1L, "个人"), COMPANY(2L, "企业");

    /** 代码 */
    private final Long   code;
    /** 信息 */
    private final String message;

    MemberTypeEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static MemberTypeEnum getByCode(Long code) {
        if (code == null) {
            return null;
        }

        for (MemberTypeEnum memberType : MemberTypeEnum.values()) {
            if (memberType.getCode().equals(code)) {
                return memberType;
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
