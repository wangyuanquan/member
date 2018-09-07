package com.rechenggit.core.domain.enums;

/**
 * <p>锁定状态枚举</p>
 * @author netfinworks
 * @version $Id: LockEnum.java 24517 2012-11-16 06:31:05Z malianhao $
 */
public enum LockEnum {
    UNLOCK(0L, "未锁定"), LOCKED(1L, "已锁定");

    /** 代码 */
    private final Long   code;
    /** 信息 */
    private final String message;

    LockEnum(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static LockEnum getByCode(Long code) {
        if (code == null) {
            return null;
        }

        for (LockEnum le : LockEnum.values()) {
            if (le.getCode().equals(code)) {
                return le;
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
