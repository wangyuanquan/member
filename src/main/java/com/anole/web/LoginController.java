package com.anole.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anole.core.common.BaseResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zhangke on 2017/2/21.
 */
@Controller
@RequestMapping("/auth")
public class LoginController extends BaseController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    /**
     * 跳转登录页
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login() {
        return "login";
    }

    /**
     * 登陆
     * @param userName 手机号
     * @param password 密码
     * @param picCode 图片验证码
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public BaseResponse login(String userName, String password, String picCode, String phoneCode,
                              HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        try {
            String JSESSIONID = "";
            for (Cookie cookie : request.getCookies()) {
                if("JSESSIONID".equals(cookie.getName())){
                    JSESSIONID = cookie.getValue();
                };
            }
            String token = UUID.randomUUID().toString().replace("-", "");



        } catch (Exception e) {
            e.printStackTrace();
            new BaseResponse(1, "登陆失败");
        }
        return new BaseResponse();
    }

}