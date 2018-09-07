package com.rechenggit.core.domain.enums;

/**
 * <p>商户类型枚举</p>
 * @author chenfei
 * @version $Id: MerchantStatusEnum.java, v 0.1 2012-11-19 上午10:35:53 cf Exp $
 */
public enum  MerchantTypeEnum {
    
    EXTERNAL(0L, "外部商户"), INTERNAL(1L, "内部商户"), RELATED(2L, "关联商户");
    
    /** 代码 */
    private final Long   code;
    /** 信息 */
    private final String message;

    private MerchantTypeEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static MerchantTypeEnum getByCode(Long code) {
        if(code == null){
            return null;
        }
        for (MerchantTypeEnum item : MerchantTypeEnum.values()) {
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
