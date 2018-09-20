package com.rechenggit.util;

import com.rechenggit.core.common.BaseResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class ResponseUtils {
    private static final Logger logger = LoggerFactory.getLogger(ResponseUtils.class);

    public static BaseResponse getBaseResponse(String code) {
        BaseResponse baseResponse;
        switch(code){
            case "REQUEST_PARAMETER" :
                baseResponse = new BaseResponse(502,"parameter.invalid");
                break;
            case "SERVICE_REPEAT" :
                baseResponse = new BaseResponse(501,"service.repeat");
                break;
            case "ACTIVATION_NOTHING" :
                baseResponse = new BaseResponse(502,"activation.fail.nothing");
                break;
            case "ACTIVATION_REPEAT" :
                baseResponse = new BaseResponse(502,"activation.already.repeat");
                break;
            case "ACTIVATION_UNREGISTERED_IDENTITY" :
                baseResponse = new BaseResponse(502,"parameter.invalid");
                break;
            case "ACTIVATION_UNREGISTERED_MEMBER" :
                baseResponse = new BaseResponse(502,"parameter.invalid");
                break;
            case "ACTIVATION_UNREGISTERED_OPERATOR" :
                baseResponse = new BaseResponse(502,"parameter.invalid");
                break;
            case "ACTIVATION_UNREGISTERED_LOGINNAME" :
                baseResponse = new BaseResponse(502,"parameter.invalid");
                break;
            case "ACTIVATION_DIFFERENCE" :
                baseResponse = new BaseResponse(502,"parameter.invalid");
                break;
            case "MAILBOX_SENDING" :
                baseResponse = new BaseResponse(506,"email.fail");
                break;
            default :
                baseResponse = new BaseResponse(500,"operation.fail");
        }
        return baseResponse;
    }


}

