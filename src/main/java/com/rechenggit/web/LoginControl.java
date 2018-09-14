package com.rechenggit.web;

import com.alibaba.fastjson.JSONObject;
import com.netfinworks.common.domain.OperationEnvironment;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.domain.BaseMember;
import com.rechenggit.core.domain.login.EnterpriseServiceInfo;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;
import com.rechenggit.core.domain.login.ServicePasswordInfo;
import com.rechenggit.core.domainservice.service.LoginService;
import com.rechenggit.core.domainservice.validator.MemberValidator;
import com.rechenggit.core.domainservice.validator.OperatorValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/member")
public class LoginControl extends BaseControl {
    private final static Logger logger = LoggerFactory.getLogger(LoginControl.class);
    @Autowired
    private MemberValidator memberValidator;
    @Autowired
    private OperatorValidator operatorValidator;
    @Autowired
    private LoginService loginService;
    @PostMapping("/enterpriseLogin")
    public BaseResponse enterpriselogin(@RequestBody OperatorLoginPwdRequest request){
        BaseResponse response =new BaseResponse();
        try {
            Member member =memberValidator.validateMemberExistAndNormal(
                    request.getIdentity(), request.getPlatFormType());
            Operator operator = operatorValidator.validateOperatorExistAndNormal(
                    member.getMemberId(), request.getLoginName(), request.getPlatFormType());
            operatorValidator.validateLoginPassWord(operator.getPassword());
            loginService.checkLoginPwd(operator, request.getPassword());
            if (logger.isInfoEnabled()) {
                logger.info("验证操作员登陆密码返回对象 : " + response.toString());
            }
            response.setMessage("");
            return success(response);
        } catch (Exception e) {
            logger.error("验证操作员登陆密码异常 : {}", e);
            response.setStatus(500);
            response.setMessage(e.getMessage());
            return fail(response);
        }
    }
    //注册
    @PostMapping("/service")
    public BaseResponse service(@RequestBody @Validated EnterpriseServiceInfo serviceInfo , BindingResult result){
        BaseResponse<EnterpriseServiceInfo> response = new BaseResponse();
        try {
            validate(result);
            logger.info("注册serviceInfo:"+ JSONObject.toJSONString(serviceInfo));
            response = loginService.enterpriseService(serviceInfo);
        } catch (Exception e) {
            logger.error("注册信息异常 : ", e);
            response.setStatus(504);
            response.setMessage(e.getMessage());
        }
        return response;
    }
    //注册
    @PostMapping("/servicePassword")
    public BaseResponse servicePassword(@RequestBody @Validated ServicePasswordInfo servicePasswordInfo , BindingResult result){
        BaseResponse<ServicePasswordInfo> response = new BaseResponse();
        try {
            validate(result);
            logger.info("提交密码:"+ JSONObject.toJSONString(servicePasswordInfo));
            response = loginService.saveServicePasswordInfo(servicePasswordInfo);
        } catch (Exception e) {
            logger.error("注册信息异常 : ", e);
            response.setStatus(504);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PostMapping("/personalLogin")
    public BaseResponse queryOperator(OperationEnvironment environment,
                                      OperatorLoginPwdRequest request){
        return null;
    }
    @PostMapping("/queryOperator")
    public BaseResponse personallogin(OperationEnvironment environment,
                                        OperatorLoginPwdRequest request){
         return null;
    }
}
