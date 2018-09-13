package com.rechenggit.core.domainservice.service;

import com.netfinworks.common.domain.OperationEnvironment;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.domain.login.EnterpriseServiceInfo;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;

public interface LoginService {
    /**
     * 验证操作员登陆密码，本接口只适用企业会员，个人商户
     * @param environment
     * @param request
     * @return
     */
    LoginRequest checkOperatorLoginPwd(OperationEnvironment environment,
                                       OperatorLoginPwdRequest request);
    /**
     * 注册
     * @return
     */
    BaseResponse enterpriseService(EnterpriseServiceInfo serviceInfo);
}
