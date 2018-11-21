package com.anole.core.domain.enums;

/**
 * <p>商户状态枚举</p>
 * @author chenfei
 * @version $Id: MerchantStatusEnum.java, v 0.1 2012-11-19 上午10:35:53 cf Exp $
 */
public enum  MerchantStatusEnum {
    
    UNACTIVE(0L, "未激活"), ACTIVE(1L, "激活"), LOCK(2L, "锁定"), CANCEL(3L, "注销");
    
    /** 代码 */
    private final Long   code;
    /** 信息 */
    private final String message;

    private MerchantStatusEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static MerchantStatusEnum getByCode(Long code) {
        if(code == null){
            return null;
        }
        for (MerchantStatusEnum item : MerchantStatusEnum.values()) {
            if (item.code.equals(code)) {
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

}
