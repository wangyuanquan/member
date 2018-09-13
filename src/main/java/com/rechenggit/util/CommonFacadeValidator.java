package com.rechenggit.util;

import com.netfinworks.common.lang.StringUtil;
import com.rechenggit.core.exception.MaIllegalArgumentException;

/**
 * <p>验证公共参数类</p>
 */
public class CommonFacadeValidator {
    /**
     * @param LoginPwd 登陆密码
     * @param ismust 是否必填
     */
    public static void checkLoginPwd(String LoginPwd, boolean ismust) {
        if (ismust && StringUtil.isBlank(LoginPwd)) {
            throw new MaIllegalArgumentException("密码不能为空");
        }
        if (LoginPwd != null && LoginPwd.length() > FieldLength.LOGIN_PASSWORD) {
            throw new MaIllegalArgumentException("密码长度不能大于" + FieldLength.LOGIN_PASSWORD + "位");
        }
    }
    /**
     * 验证会员标识
     * @param identity
     * @param ismust
     */
    public static void checkIdentity(String identity, boolean ismust) {
        if (ismust && StringUtil.isBlank(identity)) {
            throw new MaIllegalArgumentException("会员标识不能为空");
        }
        if (Utils.getByteLen(identity) > FieldLength.IDENTITY) {
            throw new MaIllegalArgumentException("会员标识长度不能大于" + FieldLength.IDENTITY + "位");
        }
    }
    /**
     * 验证登录名
     * @param loginName
     */
    public static void checkLoginName(String loginName) {
        if (StringUtil.isBlank(loginName)) {
            throw new MaIllegalArgumentException("登录名不能为空");
        }
        if (Utils.getByteLen(loginName) > FieldLength.LOGIN_NAME) {
            throw new MaIllegalArgumentException("登录名长度不能大于" + FieldLength.LOGIN_NAME + "位");
        }
    }

}
