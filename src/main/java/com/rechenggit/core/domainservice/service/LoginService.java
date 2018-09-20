package com.rechenggit.core.domainservice.service;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.domain.login.*;
import com.rechenggit.core.exception.ErrorCodeException.CommonException;
import com.rechenggit.core.exception.MaBizException;

public interface LoginService {
    /**
     * 验证操作员登陆密码，本接口只适用企业会员，个人商户
     * @param request
     * @return
     */
    LoginRequest checkOperatorLoginPwd(
                                       OperatorLoginPwdRequest request);
    /**
     * 注册
     * @return
     */
    ServicePasswordInfo enterpriseService(EnterpriseServiceInfo serviceInfo)throws CommonException;

    void checkLoginPwd(Operator operator, String password) throws MaBizException;

    public void checkPwd(Operator operator,String validatePwd) throws MaBizException;

    public boolean isLockTracking(Operator operator);

    void resetLock(Operator operator);

    long onWrongPwdInput(Operator operator);
    /**
     * 保存登录密码，交易密码.激活账号
     * @return
     */
    BaseResponse saveServicePasswordInfo(ServicePasswordInfo servicePasswordInfo)throws CommonException;
    /**
     * 修改登录密码
     * @return
     */
    BaseResponse modifyLoginPassword(LoginPasswordInfo loginPasswordInfo)throws CommonException;
    /**
     * 修改交易密码
     * @return
     */
    BaseResponse modifyTransactionPassword(TransactionPasswordInfo transactionPasswordInfo)throws CommonException;

    /**
     * 激活账号
     * @return
     */
    BaseResponse verifyingMailbox(String email,String code)throws CommonException;
    /**
     * 找回登录密码，邮箱发送验证码
     * @return
     */
    BaseResponse findLoginPassword(String email)throws CommonException;
}
