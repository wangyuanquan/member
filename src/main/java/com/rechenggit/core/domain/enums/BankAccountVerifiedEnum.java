/**
 * 
 */
package com.rechenggit.core.domain.enums;

/**
 * <p>银行账号认证状态</p>
 * @author fangjilue
 * @version $Id: BankAccountVerifiedEnum.java, v 0.1 2012-6-18 下午4:25:20 fangjilue Exp $
 */
public enum BankAccountVerifiedEnum {

	UN_VERIFIED(0, "未认证"), VERIFIED(1, "已经认证");

    /** 代码 */
    private final Integer   code;
    /** 信息 */
    private final String message;

    BankAccountVerifiedEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static BankAccountVerifiedEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (BankAccountVerifiedEnum statusEnum : BankAccountVerifiedEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
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
