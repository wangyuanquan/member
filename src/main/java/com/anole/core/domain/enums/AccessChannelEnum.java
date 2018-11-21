/**
 * 
 */
package com.anole.core.domain.enums;

import org.apache.commons.lang.StringUtils;

/**
 * <p>注释</p>
 * @author fangjilue
 * @version $Id: AccessChannelEnum.java, v 0.1 2013-10-18 下午4:01:40 fangjilue Exp $
 */
public enum AccessChannelEnum {
    
    WEB("WEB","pc"),
    WAP("WAP","mobile");
    
    /** 代码 */
    private final String code;
    
    private final String ffsCode;
    

    private AccessChannelEnum(String code, String ffsCode) {
        this.code = code;
        this.ffsCode = ffsCode;
    }


    public String getCode() {
        return code;
    }


    public String getFfsCode() {
        return ffsCode;
    }
    
    public static AccessChannelEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (AccessChannelEnum item : AccessChannelEnum.values()) {
            if (item.getCode().equals(code) || item.getFfsCode().equals(code)) {
                return item;
            }
        }

        return null;
    }

}
