package com.rechenggit.util;

import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;

public class LoginPwdFacadeValidator {
    /**
     * 验证操作员登陆密码请求信息
     * @param request
     */
    public  static void validator(OperatorLoginPwdRequest request){
        //验证用户名
        CommonFacadeValidator.checkLoginName(request.getUsername());
        //验证密码
        CommonFacadeValidator.checkLoginPwd(request.getPassword(), true);
    }
}
