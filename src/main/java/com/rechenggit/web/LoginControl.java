package com.rechenggit.web;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.netfinworks.common.domain.OperationEnvironment;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.exception.ErrorCodeException.CommonException;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.domain.login.EmailMailboxInfo;
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
import java.util.HashMap;
import java.util.Map;

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
        BaseResponse response = new BaseResponse();
        try {
            Member member =memberValidator.validateMemberExistAndNormal(
                    request.getIdentity(), request.getPlatFormType());
            Operator operator = operatorValidator.validateOperatorExistAndNormal(
                    member.getMemberId(), StringUtils.isEmpty(request.getLoginName())?"Admin":request.getLoginName(),
                    request.getPlatFormType() == null?1:request.getPlatFormType());
            operatorValidator.validateLoginPassWord(operator.getPassword());
            loginService.checkLoginPwd(operator, request.getPassword());
            if (logger.isInfoEnabled()) {
                logger.info("验证操作员登陆密码返回对象 : " + response.toString());
            }
            Map<String,String> data=new HashMap<>();
            data.put("operatorId",operator.getOperatorId());
            data.put("memberId",member.getMemberId());
            data.put("memberName",member.getMemberName());
           /*  Map<String, String> map = new HashMap<>();
           JWTInfo jwtInfo = new JWTInfo(request.getLoginName(), member.getMemberId(), operator.getOperatorId());
            Date expireTime = DateTime.now().plusSeconds(jwtTokenUtil.getExpire()).toDate();
            String token = jwtTokenUtil.generateToken(jwtInfo, map, expireTime);*/
            response.setData(data);
        } catch (Exception e) {
            logger.error("验证操作员登陆密码异常 : {}", e);
            return fail();
        }
        return success(response);
    }
    //注册
    @PostMapping("/service")
    public BaseResponse service(@RequestBody @Validated EnterpriseServiceInfo serviceInfo , BindingResult result){
        BaseResponse response = new BaseResponse();
        try {
            validate(result);
            logger.info("注册serviceInfo:"+ JSONObject.toJSONString(serviceInfo));
            ServicePasswordInfo servicePasswordInfo = loginService.enterpriseService(serviceInfo);
            if(servicePasswordInfo == null){
                return  fail(new BaseResponse("",""));
            }
            response.setData(servicePasswordInfo);
        }catch (CommonException e) {
            logger.error("注册异常，该邮箱已注册 : "+ e.getMemo());
            return  fail(new BaseResponse(502,"service.repeat"));
        } catch (Exception e) {
            logger.error("注册信息异常 : ", e);
            return  fail();
        }
        return success(response);
    }
    //激活邮箱
    @RequestMapping("/verifyingMailbox")
    public BaseResponse servicePassword(@RequestBody @Validated EmailMailboxInfo mailboxInfo, BindingResult result){
        BaseResponse<ServicePasswordInfo> response = new BaseResponse();
        try {
            validate(result);
            logger.info("激活邮箱:"+ mailboxInfo.getEmail());
            response = loginService.verifyingMailbox(mailboxInfo.getEmail(),mailboxInfo.getCode());
        } catch (Exception e) {
            logger.error("激活失败 : ", e);
            return  fail();
        }
        return success(response);
    }
    //注册密码
    @PostMapping("/servicePassword")
    public BaseResponse servicePassword(@RequestBody @Validated ServicePasswordInfo servicePasswordInfo , BindingResult result){
        BaseResponse<ServicePasswordInfo> response = new BaseResponse();
        try {
            validate(result);
            logger.info("提交密码:"+ JSONObject.toJSONString(servicePasswordInfo));
            response = loginService.saveServicePasswordInfo(servicePasswordInfo);
        } catch (Exception e) {
            logger.error("注册信息异常 : ", e);
            return  fail();
        }
        return success(response);
    }
    //找回登录密码，向邮箱发送验证码
    @PostMapping("/findLoginPassword")
    public BaseResponse findLoginPassword(@RequestBody @Validated EmailMailboxInfo mailboxInfo, BindingResult result){
        BaseResponse<ServicePasswordInfo> response = new BaseResponse();
        try {
            validate(result);
            logger.info("找回登录密码:"+ JSONObject.toJSONString(mailboxInfo));
            response = loginService.findLoginPassword(mailboxInfo.getEmail());
        } catch (Exception e) {
            logger.error("找回登录密码异常 : ", e);
            return  fail();
        }
        return success(response);
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
