package com.anole.core.domainservice.service.impl;

import com.anole.core.common.BaseResponse;
import com.anole.core.dal.dataobject.UserInfo;
import com.anole.core.domain.enums.ResponseCode;
import com.anole.core.domain.login.UserLoginRequest;
import com.anole.core.domain.settlements.EnterpriseSettlementInfo;
import com.anole.core.domain.settlements.Settlements;
import com.anole.core.domainservice.repository.LoginRepository;
import com.anole.core.domainservice.repository.SettlementRepository;
import com.anole.core.domainservice.service.LoginService;
import com.anole.core.domainservice.service.SettlementService;
import com.anole.core.exception.MaBizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserInfo checkLogin(UserLoginRequest userLogin) throws MaBizException {
        UserInfo user = loginRepository.queryUserInfoByName(userLogin.getLoginName());
        if(user == null){
            throw new MaBizException(ResponseCode.MEMBER_NOT_EXIST, "账户名不存在");
        }else if(!userLogin.getPassword().equals(user.getLoginPassword())){
            throw new MaBizException(ResponseCode.LOGIN_PASSWORD_ERROR, "账户名或密码错误");
        }
        return user;
    }
}
