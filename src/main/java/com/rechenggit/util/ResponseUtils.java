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

    public static BaseResponse getBaseResponse(String errorCode,String errorMsg) {
        return new BaseResponse();
    }


}

