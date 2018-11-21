package com.anole.core.domain.enums;

/**
 * <p>会员状态枚举</p>
 * 
 * 详见《详细设计文档》中关于会员状态的状态变化图
 * 
 * @author netfinworks
 * @version $Id: MemberStatusEnum.java 24517 2012-11-16 06:31:05Z malianhao $
 */
public enum MemberStatusEnum {
    UNACTIVE(0, "未激活"), NORMAL(1, "正常"), SLEEP(2, "休眠"), CANCEL(3, "销户");

    /** 代码 */
    private final Integer   code;
    /** 信息 */
    private final String message;

    MemberStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static MemberStatusEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (MemberStatusEnum memberStatus : MemberStatusEnum.values()) {
            if (memberStatus.getCode().equals(code)) {
                return memberStatus;
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
