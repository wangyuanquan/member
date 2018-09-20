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
            "REQUEST_PARAMETER ", "请求参数异常");
    public static CommonException SERVICE_REPEAT                 = new ErrorCodeException.CommonException(
                "SERVICE_REPEAT", "邮箱已注册");
    public static CommonException ACTIVATION_NOTHING          = new ErrorCodeException.CommonException(
                "ACTIVATION_NOTHING", "激活失败，无相关信息");
    public static CommonException ACTIVATION_REPEAT     = new ErrorCodeException.CommonException(
                "ACTIVATION_REPEAT","已经激活，重复激活");
    public static CommonException ACTIVATION_UNREGISTERED_IDENTITY   = new ErrorCodeException.CommonException(
                "ACTIVATION_UNREGISTERED_IDENTITY","tm_member_identity表根据memberId找不到信息");
    public static CommonException ACTIVATION_UNREGISTERED_MEMBER  = new ErrorCodeException.CommonException(
            "ACTIVATION_UNREGISTERED_MEMBER","tm_member表根据memberId找不到信息");
    public static CommonException ACTIVATION_UNREGISTERED_OPERATOR  = new ErrorCodeException.CommonException(
            "ACTIVATION_UNREGISTERED_OPERATOR","tm_operator表根据memberId找不到信息");
    public static CommonException ACTIVATION_UNREGISTERED_LOGINNAME  = new ErrorCodeException.CommonException(
            "ACTIVATION_UNREGISTERED_LOGINNAME","tr_login_name表根据memberId找不到信息");
    public static CommonException ACTIVATION_DIFFERENCE  = new ErrorCodeException.CommonException(
            "ACTIVATION_DIFFERENCE","tm_operator中的memberId operatorId跟参数不一致");
    public static CommonException MAILBOX_SENDING          = new ErrorCodeException.CommonException(
            "MAILBOX_SENDING", "邮箱发送失败");

}
