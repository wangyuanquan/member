package com.anole.web;


import com.anole.core.common.BaseResponse;
import com.anole.core.domain.login.UserLoginRequest;
import com.anole.core.domainservice.service.LoginService;
import com.anole.core.domainservice.service.SettlementService;
import com.anole.core.exception.MaBizException;
import com.anole.core.exception.ValidateException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangke on 2017/2/21.
 */
@Controller
@RequestMapping("/user")
public class LoginController extends BaseController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;
    /**
     * 跳转登录页
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login() {
        return "mall/login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public BaseResponse login(@RequestBody @Validated UserLoginRequest userLogin, BindingResult result) {
        BaseResponse response = new BaseResponse();
        try{
            validate(result);
            //登录验证
            response = loginService.checkLogin(userLogin);
        }catch (ValidateException e){
            logger.error("登录信息验证失败",e.getMessage());
            response.setStatus(505);
            response.setMessage(e.getMessage());
            return  fail(response);
        }catch (MaBizException e) {
            logger.error(e.getMessage());
            return fail(new BaseResponse(e.getResponseCode().getCode(),e.getResponseCode().getMessage()));
        }catch (Exception e) {
            logger.error("登录异常 ", e);
            response.setStatus(500);
            response.setMessage(e.getMessage());
            return fail(response);
        }
        return success(response);
    }

}