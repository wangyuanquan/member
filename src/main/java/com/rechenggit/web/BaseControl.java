package com.rechenggit.web;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.exception.ValidateException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class BaseControl {
    private final static Logger logger = LoggerFactory.getLogger(BaseControl.class);
    @Autowired
    protected HttpServletRequest request;

    @InitBinder
    protected void initBinder(HttpServletRequest  request) {
        String lang = request.getHeader("lang");
        if (StringUtils.isBlank(lang)) {
            lang = "en_US";

        }
        LocaleContextHolder.setLocale(new Locale(lang.split("_")[0], lang.split("_")[1]));
    }
    public BaseResponse success(){
        return new BaseResponse();

    }
    public BaseResponse success(BaseResponse response){
        return response;

    }
    public BaseResponse fail(BaseResponse response){
        if (response ==null){
            return fail();
        }
        return response;

    }
    public BaseResponse fail(){
        BaseResponse response=new BaseResponse();
        response.setStatus(500);
        response.setMessage("请求异常");
        return response;

    }
    public void validate(BindingResult result) throws ValidateException{

        StringBuffer message=new StringBuffer();
        if (result.hasErrors()) {
            StringBuffer errorMsg = new StringBuffer();
            for (ObjectError objectError : result.getAllErrors()) {
                errorMsg.append(" ").append(objectError.getDefaultMessage());
            }
            logger.info("{}参数不合法：{}",errorMsg);
            throw new ValidateException(message.append(errorMsg).toString());
        }


    }
}
