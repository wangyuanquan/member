package com.rechenggit.web;

import com.netfinworks.common.domain.OperationEnvironment;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.domain.login.EnterpriseServiceInfo;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;
import com.rechenggit.core.domainservice.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/member")
public class LoginControl extends BaseControl {
    private final static Logger logger = LoggerFactory.getLogger(LoginControl.class);
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public BaseResponse login(OperationEnvironment environment,
                              OperatorLoginPwdRequest request){
        try {
            LoginRequest response = loginService.checkOperatorLoginPwd(environment, request);
            if (logger.isInfoEnabled()) {
                logger.info("验证操作员登陆密码返回对象 : " + response.toString());
            }
            return response;
        } catch (Exception e) {
            logger.error("验证操作员登陆密码异常 : ", e);
            throw new RuntimeException("调用checkOperatorLoginPwd接口异常");
        }
    }
    @PostMapping("/service")
    public BaseResponse service(EnterpriseServiceInfo serviceInfo){
        BaseResponse<EnterpriseServiceInfo> response = new BaseResponse();
        try {
           loginService.enterpriseService(serviceInfo);
        } catch (Exception e) {
            logger.error("注册信息异常 : ", e);
        }
        return response;
    }

}
