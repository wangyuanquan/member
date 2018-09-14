package com.rechenggit.web;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.common.OperationEnvironment;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.domain.BaseMember;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;
import com.rechenggit.core.domainservice.service.LoginService;
import com.rechenggit.core.domainservice.validator.MemberValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/login")
public class LoginControl extends BaseControl {
    private final static Logger logger = LoggerFactory.getLogger(LoginControl.class);
    @Autowired
    private MemberValidator memberValidator;

    @PostMapping("/enterpriseLogin")
    public BaseResponse enterpriselogin(OperationEnvironment environment,
                              OperatorLoginPwdRequest request){
        BaseResponse response =new BaseResponse();
        try {
            Member member =memberValidator.validateMemberExistAndNormal(
                    request.getLoginName(), request.getPlatFormType());

            if (logger.isInfoEnabled()) {
                logger.info("验证操作员登陆密码返回对象 : " + response.toString());
            }
            return response;
        } catch (Exception e) {
            logger.error("验证操作员登陆密码异常 : ", e);
            throw new RuntimeException("调用checkOperatorLoginPwd接口异常");
        }
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
