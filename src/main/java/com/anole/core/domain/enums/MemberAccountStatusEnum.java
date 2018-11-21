/**
 * 
 */
package com.anole.core.domain.enums;

/**
 * <p>会员账户状态标志枚举</p>
 * @author fjl
 * @version $Id: MemberAccountStatusEnum.java 24852 2012-11-19 11:08:00Z fangjilue $
 */
public enum MemberAccountStatusEnum {

    NOTACTIVATED(0, "会员未激活，不开赋值账户"), ACTIVATED(1, "会员激活，开赋值基本户未激活"), ACTIVATED_ALL(2,"会员账户都激活");

    /** 代码 */
    private final Integer code;
    /** 信息 */
    private final String  message;

    MemberAccountStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static MemberAccountStatusEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (MemberAccountStatusEnum le : MemberAccountStatusEnum.values()) {
            if (le.getCode().equals(code)) {
                return le;
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
