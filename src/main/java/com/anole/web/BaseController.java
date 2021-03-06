package com.anole.web;

import com.anole.core.common.BaseResponse;
import com.anole.core.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class BaseController {
    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private MessageSource messageSource;
    @Autowired
    protected HttpServletRequest request;
    /*前置 国际化
    @InitBinder
    protected void initBinder(HttpServletRequest  request) {
        String lang = request.getHeader("lang");
        if (StringUtils.isBlank(lang)) {
            lang = "en_US";

        }
        LocaleContextHolder.setLocale(new Locale(lang.split("_")[0], lang.split("_")[1]));
    }
    */
    public BaseResponse success(){
        BaseResponse response = new BaseResponse(200,getMessage("operation.success"));
        return response;
    }
    public BaseResponse success(BaseResponse response){
        String message = getMessage(response.getMessage());
        response.setMessage(message);
        return response;

    }
    public BaseResponse fail(BaseResponse response){
        if (response ==null){
            return fail();
        }
        String message = getMessage(response.getMessage());
        response.setMessage(message);
        return response;

    }
    public BaseResponse fail(){
        BaseResponse response = new BaseResponse(500,getMessage("operation.fail"));
        return response;
    }
    public void validate(BindingResult result) throws ValidateException{

        StringBuffer message=new StringBuffer();
        if (result.hasErrors()) {
            StringBuffer errorMsg = new StringBuffer();
            for (ObjectError objectError : result.getAllErrors()) {
                errorMsg.append("，").append(objectError.getDefaultMessage());
            }
            logger.info("参数不合法：{}",errorMsg);
            throw new ValidateException(message.append(errorMsg).toString());
        }
    }
    /**
     *
     * @param code ：对应messages配置的key.
     * @param args : 数组参数.
     * @param defaultMessage : 没有设置key的时候的默认值.
     * @return
     */
    public String getMessage(String code,Object[] args,String defaultMessage){
        //这里使用比较方便的方法，不依赖request.
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }
    /**
     *
     * @param code ：对应messages配置的key.
     * @param defaultMessage : 没有设置key的时候的默认值.
     * @return
     */
    public String getMessage(String code,String defaultMessage){
        //这里使用比较方便的方法，不依赖request.
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, defaultMessage, locale);
    }
    /**
     *
     * @param code ：对应messages配置的key.
     * @return
     */
    public String getMessage(String code){
        //这里使用比较方便的方法，不依赖request.
       // Locale locale = LocaleContextHolder.getLocale();
        //System.out.println(locale);
        //Locale.CHINESE
        //Locale.US
        return messageSource.getMessage(code, null, code, Locale.CHINESE);
    }
}