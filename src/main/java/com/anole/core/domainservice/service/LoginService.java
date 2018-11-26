package com.anole.core.domainservice.service;

import com.anole.core.common.BaseResponse;
import com.anole.core.domain.login.UserLoginRequest;
import com.anole.core.exception.MaBizException;

public interface LoginService {

    /**
     * 登录验证
     * @return
     */
    BaseResponse checkLogin(UserLoginRequest userLogin) throws MaBizException ;


}
