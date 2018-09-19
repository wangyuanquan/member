package com.rechenggit.core.exception;

import com.rechenggit.core.exception.ErrorCodeException.CommonException;

/**
 *
 * <p>错误码常量类</p>
 * @author leelun
 * @version $Id: CommonDefinedException.java, v 0.1 2013-11-18 下午4:20:37 lilun Exp $
 */
public class CommonDefinedException {
    public static CommonException SERVICE_REPEAT                 = new ErrorCodeException.CommonException(
                "SERVICE_REPEAT", "service.repeat");
    public static CommonException INPUT_CHARSET_ERROR          = new ErrorCodeException.CommonException(
                "INPUT_CHARSET_ERROR", "编码类型错误");

    public static CommonException REQUIRED_FIELD_NOT_EXIST     = new ErrorCodeException.CommonException(
                "REQUIRED_FIELD_NOT_EXIST","必填字段未填写");
    public static CommonException FIELD_LENGTH_EXCEEDS_LIMIT   = new ErrorCodeException.CommonException(
                "FIELD_LENGTH_EXCEEDS_LIMIT","字段长度超过限制");

}
