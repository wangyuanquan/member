package com.rechenggit.core.domain.enums;

import com.netfinworks.common.lang.StringUtil;

/**
 * <p>支付属性</p>
 * @author wangbin.ben
 * @version $Id: PayAttributeEnum.java, v 0.1 2013-4-10 下午2:58:15 User Exp $
 */
public enum PayAttributeEnum {
    QUICKPAY("qpay", "大快捷"), 
    BANKSIGNQUICKPAY("bsqpay", "小快捷"), 
    UMPPAY("umppay", "联动优势"), 
    NORMAL("normal","普通卡");
    
    private final String code;
    private final String message;

    private PayAttributeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static PayAttributeEnum getByCode(String code) {
        if (StringUtil.isBlank(code)) {
            return null;
        }

        for (PayAttributeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
