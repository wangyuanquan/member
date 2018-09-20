package com.rechenggit.core.exception;

import com.rechenggit.core.exception.ErrorCodeException.CommonException;

/**
 *
 * <p>错误码常量类</p>
 * @author leelun
 * @version $Id: CommonDefinedException.java, v 0.1 2013-11-18 下午4:20:37 lilun Exp $
 */
public class CommonDefinedException {
    public static CommonException REQUEST_PARAMETER                  = new ErrorCodeException.CommonException(
            "502", "parameter.invalid");
    public static CommonException SERVICE_REPEAT                 = new ErrorCodeException.CommonException(
            "501", "service.repeat");
    public static CommonException ACTIVATION_NOTHING          = new ErrorCodeException.CommonException(
            "502", "activation.fail.nothing");
    public static CommonException ACTIVATION_REPEAT     = new ErrorCodeException.CommonException(
            "502","activation.already.repeat");
    public static CommonException ACTIVATION_UNREGISTERED_IDENTITY   = new ErrorCodeException.CommonException(
            "502","parameter.invalid");
    public static CommonException ACTIVATION_UNREGISTERED_MEMBER  = new ErrorCodeException.CommonException(
            "502","parameter.invalid");
    public static CommonException ACTIVATION_UNREGISTERED_OPERATOR  = new ErrorCodeException.CommonException(
            "502","parameter.invalid");
    public static CommonException ACTIVATION_UNREGISTERED_LOGINNAME  = new ErrorCodeException.CommonException(
            "502","parameter.invalid");
    public static CommonException ACTIVATION_DIFFERENCE  = new ErrorCodeException.CommonException(
            "502","parameter.invalid");
    public static CommonException MAILBOX_SENDING          = new ErrorCodeException.CommonException(
            "506", "email.fail");

}
