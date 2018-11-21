package com.anole.core.domain.enums;



/**
 * <p>注释</p>
 * @author wangbin.ben
 * @version $Id: YesNoEnum.java, v 0.1 2013-4-10 下午3:16:25 User Exp $
 */
public enum YesNoEnum {
    YES("Y", "是"),

    NO("N", "否");

    /** 代码 */
    private final String code;
    /** 信息 */
    private final String message;

    /**
     * 构造
     * @param code
     * @param message
     */
    YesNoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据代码获取
     * @param code
     * @return
     */
    public static YesNoEnum getByCode(String code) {
        if (code.isEmpty()) {
            return null;
        }

        for (YesNoEnum type : YesNoEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
