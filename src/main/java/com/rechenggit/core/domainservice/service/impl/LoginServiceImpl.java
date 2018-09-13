package com.rechenggit.core.domainservice.service.impl;


import com.netfinworks.common.domain.OperationEnvironment;
import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;
import com.rechenggit.core.domainservice.repository.LoginRepository;
import com.rechenggit.core.domainservice.service.LoginService;
import com.rechenggit.util.LoginPwdFacadeValidator;
import com.rechenggit.util.Utils;
import com.rechenggit.web.EnterPriseMemberControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginServiceImpl implements LoginService {
    private final static Logger logger = LoggerFactory.getLogger(EnterPriseMemberControl.class);
    @Autowired
    private LoginRepository loginRepository;
    @Override
    public LoginRequest checkOperatorLoginPwd(OperationEnvironment environment, OperatorLoginPwdRequest request) {
        if (logger.isInfoEnabled()) {
            logger.info("[APP->MA_1]验证操作员登陆密码请求:request={},environment={}", request,
                    Utils.toString(environment));
        }
        LoginRequest response = new LoginRequest();
        try {
            //验证信息是否有效
            LoginPwdFacadeValidator.validator(request);
            //查询会员
            Member member = loginRepository.getMemberByIdentity(request);
            //验证登录页登录密码
            Operator operator = loginRepository.getOperatorByPwd(member.getMemberId(),request);
            response.setMemberId(operator.getMemberId());
            //返回操作员编号
            response.setOperatorId(operator.getOperatorId());
            if (logger.isInfoEnabled()) {
                logger.info("[APP<-MA_1]验证操作员登陆密码返回结果:response={},environment={}", response,
                        Utils.toString(environment));
            }
        } catch (Exception e) {
            logger.error("验证操作员登陆密码错误：",e);
        }

        return response;
    }
}
