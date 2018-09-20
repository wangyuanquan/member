package com.rechenggit.core.domainservice.service.impl;


import com.alibaba.druid.util.StringUtils;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.dal.mapper.MaConstant;
import com.rechenggit.core.domain.PassWordLock;
import com.rechenggit.core.domain.PayPwdLockInfo;
import com.rechenggit.core.domain.enums.PassWordLockFlagEnum;
import com.rechenggit.core.domain.enums.ResponseCode;
import com.rechenggit.core.domain.login.*;
import com.rechenggit.core.domainservice.repository.LoginRepository;
import com.rechenggit.core.domainservice.repository.OperatorLockRepository;
import com.rechenggit.core.domainservice.service.LoginService;
import com.rechenggit.core.exception.CommonDefinedException;
import com.rechenggit.core.exception.ErrorCodeException;
import com.rechenggit.core.exception.ErrorCodeException.CommonException;
import com.rechenggit.core.exception.MaBizException;
import com.rechenggit.util.LoginPwdFacadeValidator;
import com.rechenggit.util.Utils;
import com.rechenggit.web.EnterPriseMemberControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class LoginServiceImpl implements LoginService {
    private final static Logger logger = LoggerFactory.getLogger(EnterPriseMemberControl.class);
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private OperatorLockRepository operatorLockRepository;
    @Override
    public LoginRequest checkOperatorLoginPwd(OperatorLoginPwdRequest request) {
        if (logger.isInfoEnabled()) {
            logger.info("[APP->MA_1]验证操作员登陆密码请求:request={},environment={}", request);
        }
        LoginRequest response = new LoginRequest();
        try {
            //验证信息是否有效
            LoginPwdFacadeValidator.validator(request);
            //查询会员
            Member member = loginRepository.validateMemberExistAndNormal(request.getLoginName(),request.getPlatFormType());
            //验证登录页登录密码
            Operator operator = loginRepository.getOperatorByPwd(member.getMemberId(),request);
            response.setMemberId(operator.getMemberId());
            //返回操作员编号
            response.setOperatorId(operator.getOperatorId());
            if (logger.isInfoEnabled()) {
                logger.info("[APP<-MA_1]验证操作员登陆密码返回结果:response={}", response);
            }
        } catch (Exception e) {
            logger.error("验证操作员登陆密码错误：",e);
        }

        return response;
    }

    @Override
    @Transactional
    public ServicePasswordInfo enterpriseService(EnterpriseServiceInfo serviceInfo) throws CommonException {
        return loginRepository.enterpriseService(serviceInfo);
    }

    @Override
    @Transactional
    public void checkLoginPwd(Operator operator, String password) throws MaBizException {
        operator.setFlag(PassWordLockFlagEnum.LOGIN_PASSWORD_FLAG);
        //验证登陆密码
          checkPwd(operator, Utils.hashSignContent(password));
    }

    @Override
    public void checkPwd(Operator operator, String validatePwd) throws MaBizException {
        //查询是否有锁定进行中的纪录
        boolean isLockTracking = this.isLockTracking(operator);
        if (isLockTracking) {
            //锁定则异常
            PayPwdLockInfo pwdLockInfo = this.isLocked(operator);
            if (pwdLockInfo.isLocked()) {
                if(PassWordLockFlagEnum.LOGIN_PASSWORD_FLAG == operator.getFlag()){
                    throw new MaBizException(ResponseCode.LOGIN_PASSWORD_LOCKED,
                            String.valueOf(pwdLockInfo.getRemainTime()));
                }else{
                    throw new MaBizException(ResponseCode.PASSWORD_LOCKED,
                            String.valueOf(pwdLockInfo.getRemainTime()));
                }
            }
        }
        if (StringUtils.equalsIgnoreCase(getPwd(operator), validatePwd)) {
            //如果存在锁定记录，则清除之前的纪录，重新统计
            if (isLockTracking) {
                this.resetLock(operator);
            }
        } else {
            long count = this.onWrongPwdInput(operator);
            if (count <= 0) {
              /*  PayPwdLockConfig opConfig = this.getPwdLockConfig(operator.getFlagEnum());
                if (opConfig != null) {
                    if (PassWordLockFlagEnum.LOGIN_PASSWORD_FLAG == operator.getFlagEnum()) {
                        throw new MaBizException(ResponseCode.LOGIN_PASSWORD_LOCKED,
                                String.valueOf(opConfig.getLockSpan()));
                    } else {
                        throw new MaBizException(ResponseCode.PASSWORD_LOCKED,
                                String.valueOf(opConfig.getLockSpan()));
                    }
                }*/
            }
            if (PassWordLockFlagEnum.LOGIN_PASSWORD_FLAG == operator.getFlag()) {
                throw new MaBizException(ResponseCode.LOGIN_PASSWORD_CHECK_FAIL);
            } else {
                throw new MaBizException(ResponseCode.PASSWORD_CHECK_FAIL);
            }
        }
    }

    private PayPwdLockInfo isLocked(Operator operator) {
       // PayPwdLockConfig opConfig = getPwdLockConfig(operator.getFlag());
     /*   if (opConfig == null) {
            //如果没有配置不锁定
            return new PayPwdLockInfo(false);
        }*/
        //逻辑删除无效的统计记录
    /*    operatorLockRepository.logicDeleteUselessCount(operator, opConfig.getInputDetectSpan(),
                opConfig.getLockSpan());
        //TODO 此逻辑有问题，如果删除失败，则将有问题
        Date lockTime = operatorLockRepository.getLockTime(operator);
        if (lockTime != null) {
            return new PayPwdLockInfo(true, lockTime, opConfig.getLockSpan());
        }

        return new PayPwdLockInfo(false);*/
        return new PayPwdLockInfo(false);
    }

    @Override
    public boolean isLockTracking(Operator operator) {
        return operatorLockRepository.getCountLock(operator.getOperatorId(),
                 operator.getFlag()) > 0 ? true : false;
    }

    @Override
    public void resetLock(Operator operator) {
        PassWordLock passWordLock = new PassWordLock();
     //   passWordLock.setAccountId(operator.getBaseAccountId());
        passWordLock.setOperatorId(operator.getOperatorId());
        passWordLock.setFlag(operator.getFlag().getCode());
        operatorLockRepository.reStore(passWordLock);
    }

    @Override
    public long onWrongPwdInput(Operator operator) {
        return MaConstant.PWD_ERROR_RETRY_COUNT;
     /*   PayPwdLockConfig opConfig = getPwdLockConfig(operator.getFlagEnum());
        //无配置可重试次数-1
        if (opConfig == null) {
            return MaConstant.PWD_ERROR_RETRY_COUNT;
        }
        //锁定操作员
        //tmOperatorCommonDAO.getOperatorByIdForUpdate(operator.getOperatorId());
        //删除无效的统计记录
        operatorLockRepository.logicDeleteUselessCount(operator, opConfig.getInputDetectSpan(),
                opConfig.getLockSpan());
        Date opCountStartTime = operatorLockRepository.getCountStartTime(operator);
        if (opCountStartTime == null) {
            //无正在统计的记录，插入一条新的统计记录
            operatorLockRepository.store(operator.getOperatorId(), operator.getBaseAccountId(),
                    operator.getFlagEnum());
            opCountStartTime = operatorLockRepository.getCountStartTime(operator);
        }
        pwdWrongRepostory.store(operator);

        long count = 0;
        //检查是否导致<OP>锁定
        long wrongInputCount = pwdWrongRepostory.countPwdWrong(operator, opCountStartTime);
        if (wrongInputCount >= opConfig.getWrongInputCount()) {
            //锁定
            if (logger.isDebugEnabled()) {
                logger.debug("<" + operator.getOperatorId() + "," + operator.getBaseAccountId()
                        + ", flag " + operator.getFlagEnum().getMessage() + ">被锁定");
            }
            operatorLockRepository.lock(operator);
            count = 0;
        } else {
            count = opConfig.getWrongInputCount() - wrongInputCount;
        }
        return count;*/
    }

    private String getPwd(Operator operator)throws MaBizException {
        switch (operator.getFlag()) {
            case LOGIN_PASSWORD_FLAG:
                return operator.getPassword();
            case PAY_PASSWORD_FLAG:
                return operator.getBasePayPassword().getPassWord();
            default:
                throw new MaBizException(ResponseCode.PASSWORD_FLAG_NULL);
        }

    }

    @Override
    @Transactional
    public BaseResponse saveServicePasswordInfo(ServicePasswordInfo servicePasswordInfo)throws CommonException {
        if(!servicePasswordInfo.getLoginPassword().equals(servicePasswordInfo.getEnterLoginPassword())){
            return new BaseResponse(505,"equals.login.pwd");
        }
        if(!servicePasswordInfo.getPaymentPassword().equals(servicePasswordInfo.getEnterPaymentPassword())){
            return new BaseResponse(505,"equals.payment.pwd");
        }
        //保存登录密码
        int result = loginRepository.saveLoginPassword(servicePasswordInfo);
        if(result == 0){
            CommonException exp = CommonDefinedException.REQUEST_PARAMETER;
            exp.setMemo(servicePasswordInfo.getMemberId());
            throw exp;
        }
        //保存交易密码
        result = loginRepository.saveTransactionPassword(servicePasswordInfo);
        if(result == 0){
            CommonException exp = CommonDefinedException.REQUEST_PARAMETER;
            exp.setMemo(servicePasswordInfo.getMemberId());
            throw exp;
        }
        //发送激活邮件
        result = loginRepository.sendActivationMail(servicePasswordInfo);
        if(result == 0){
            CommonException exp = CommonDefinedException.MAILBOX_SENDING;
            exp.setMemo(servicePasswordInfo.getMemberId());
            throw exp;
        }
        return new BaseResponse();
    }

    @Override
    public BaseResponse modifyLoginPassword(LoginPasswordInfo loginPasswordInfo) throws CommonException {
        if(!loginPasswordInfo.getLoginPassword().equals(loginPasswordInfo.getEnterLoginPassword())){
            return new BaseResponse(505,"equals.login.pwd");
        }
        //验证登录密码
        Boolean flag = loginRepository.checkLoginPassword(loginPasswordInfo.getMemberId(),loginPasswordInfo.getOldPassword());
        if(!flag){
            return new BaseResponse(504,"login.pwd.fail");
        }
        //保存登录密码
        ServicePasswordInfo servicePasswordInfo = new ServicePasswordInfo();
        BeanUtils.copyProperties(loginPasswordInfo,servicePasswordInfo);
        int result = loginRepository.saveLoginPassword(servicePasswordInfo);
        if(result == 0){
            CommonException exp = CommonDefinedException.REQUEST_PARAMETER;
            exp.setMemo(loginPasswordInfo.getMemberId());
            throw exp;
        }
        return new BaseResponse();
    }

    @Override
    public BaseResponse modifyTransactionPassword(TransactionPasswordInfo transactionPasswordInfo) throws CommonException {
        if(!transactionPasswordInfo.getPaymentPassword().equals(transactionPasswordInfo.getEnterPaymentPassword())){
            return new BaseResponse(505,"equals.payment.pwd");
        }
        //验证交易密码
        Boolean flag = loginRepository.checkTransactionPassword(transactionPasswordInfo.getOperatorId(),transactionPasswordInfo.getOldPassword());
        if(!flag){
            return new BaseResponse(504,"transaction.pwd.fail");
        }
        //保存交易密码
        ServicePasswordInfo servicePasswordInfo = new ServicePasswordInfo();
        BeanUtils.copyProperties(transactionPasswordInfo,servicePasswordInfo);
        int result = loginRepository.saveTransactionPassword(servicePasswordInfo);
        if(result == 0){
            CommonException exp = CommonDefinedException.REQUEST_PARAMETER;
            exp.setMemo(transactionPasswordInfo.getMemberId());
            throw exp;
        }
        return new BaseResponse();
    }

    @Override
    @Transactional
    public BaseResponse verifyingMailbox(String email,String code) throws CommonException{
        return loginRepository.verifyingMailbox(email,code);
    }

    @Override
    public BaseResponse findLoginPassword(String email)throws CommonException {
        return loginRepository.findLoginPassword(email);
    }
}
