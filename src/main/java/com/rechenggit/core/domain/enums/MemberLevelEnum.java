package com.rechenggit.core.domain.enums;

public enum  MemberLevelEnum {
    Bloc(1,"集团"),
    Merchant(2,"商户");


    private Integer level;
    private String  message;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    MemberLevelEnum(Integer level, String message) {
        this.level = level;
        this.message = message;
    }
    public static MemberLevelEnum getByLevel(Integer level) {
        if (level == null) {
            return null;
        }

        for (MemberLevelEnum le : MemberLevelEnum.values()) {
            if (le.getLevel().equals(level)) {
                return le;
            }
        }

        return null;
    }

}
