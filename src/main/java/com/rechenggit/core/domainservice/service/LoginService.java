package com.rechenggit.core.domainservice.service;

import com.netfinworks.common.domain.OperationEnvironment;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.domain.login.EnterpriseServiceInfo;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;
import com.rechenggit.core.exception.MaBizException;
import com.rechenggit.core.domain.login.ServicePasswordInfo;

public interface LoginService {
    /**
     * 验证操作员登陆密码，本接口只适用企业会员，个人商户
     * @param environment
     * @param request
     * @return
     */
    LoginRequest checkOperatorLoginPwd(
                                       OperatorLoginPwdRequest request);
    /**
     * 注册
     * @return
     */
    BaseResponse enterpriseService(EnterpriseServiceInfo serviceInfo);

    void checkLoginPwd(Operator operator, String password) throws MaBizException;

    public void checkPwd(Operator operator,String validatePwd) throws MaBizException;

    public boolean isLockTracking(Operator operator);

    void resetLock(Operator operator);

    long onWrongPwdInput(Operator operator);
    /**
     * 保存登录密码，交易密码.激活账号
     * @return
     */
    BaseResponse saveServicePasswordInfo(ServicePasswordInfo servicePasswordInfo);

}
