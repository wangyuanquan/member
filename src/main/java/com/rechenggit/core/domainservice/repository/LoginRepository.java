package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.domain.login.EnterpriseServiceInfo;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;
import com.rechenggit.core.domain.login.ServicePasswordInfo;
import com.rechenggit.core.exception.MaBizException;

public interface LoginRepository {
    /**
     * 查询会员 通过标识
     */
    Member validateMemberExistAndNormal(String identity,int platformType);

    /**
     * 查询操作员 通过用户 密码
     * @param request
     */
    Operator getOperatorByPwd(String memberId , OperatorLoginPwdRequest request);
    /**
     * 注册
     * @return
     */
    ServicePasswordInfo enterpriseService(EnterpriseServiceInfo serviceInfo)throws MaBizException;
    /**
     * 保存登录密码，交易密码
     * @return
     */
    BaseResponse saveServicePasswordInfo(ServicePasswordInfo servicePasswordInfo);
    /**
     * 保存登录密码
     * @return
     */
    int saveLoginPassword(ServicePasswordInfo servicePasswordInfo)throws MaBizException;
    /**
     * 验证登录密码
     * @return
     */
    Boolean checkLoginPassword(String  memberId,String  password);
    /**
     * 验证登录密码
     * @return
     */
    Boolean checkTransactionPassword(String  memberId,String  password);
    /**
     * 保存交易密码
     * @return
     */
    int saveTransactionPassword(ServicePasswordInfo servicePasswordInfo)throws MaBizException;
    /**
     * 发送激活邮件
     * @return
     */
    int sendActivationMail(ServicePasswordInfo servicePasswordInfo)throws MaBizException;
    /**
     * 激活账号
     * @return
     */
    BaseResponse verifyingMailbox(String email,String code)throws MaBizException;
    /**
     * 找回登录密码，邮箱发送验证码
     * @return
     */
    BaseResponse findLoginPassword(String email)throws MaBizException;
}
