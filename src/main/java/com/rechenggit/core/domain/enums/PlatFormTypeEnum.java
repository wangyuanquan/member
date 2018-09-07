/**
 * 
 */
package com.rechenggit.core.domain.enums;

/**
 * <p>会员平台类型枚举,只定义默认类型，其它类型在配置表中</p>
 * @author fjl
 * @version $Id: PlatFormTypeEnum.java 24517 2012-11-16 06:31:05Z malianhao $
 */
public enum PlatFormTypeEnum {
    //默认钱包
    DEFAULT(0,"钱包平台"),UID(1,"UID");
    
    /** 代码 */
    private final int   code;
    /** 信息 */
    private final String message;

    private PlatFormTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static PlatFormTypeEnum getByCode(int code) {
        for (PlatFormTypeEnum aa : PlatFormTypeEnum.values()) {
            if (aa.code == code ) {
                return aa;
            }
        }

        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
