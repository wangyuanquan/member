package com.rechenggit.core.domain.enums;

/**
 * 
 * <p>MA 基本账户类型，其它账户类型从配置表中取</p>
 * @author netfinworks
 * @version $Id: BasicAccountType.java 24517 2012-11-16 06:31:05Z malianhao $
 */
public enum BasicAccountType {

    PERSONAL_BASIC_ACCOUNT(101L, "对私基本户",AccountAttributeEnum.PERSONAL_ACCOUNT), 
    COMPANY_BASIC_ACCOUNT(201L, "对公基本户",AccountAttributeEnum.INSTUTION_ACCOUNT);

    /** 代码 */
    private final Long                 code;
    /** 信息 */
    private final String               message;

    private final AccountAttributeEnum accAttrEnum;

    BasicAccountType(Long code, String message, AccountAttributeEnum accAttrEnum) {
        this.code = code;
        this.message = message;
        this.accAttrEnum = accAttrEnum;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static BasicAccountType getByCode(Long code) {
        if (code == null) {
            return null;
        }

        for (BasicAccountType item : BasicAccountType.values()) {
            if (item.getCode().equals(code)) {
                return item;
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

    public AccountAttributeEnum getAccAttrEnum() {
        return accAttrEnum;
    }

}
