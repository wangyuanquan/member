package com.rechenggit.core.domainservice.service;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.account.OpenAccountInfo;
import com.rechenggit.core.exception.MaBizException;

public interface AccountService {

    /**
     * 开户
     * @return
     */
    BaseResponse openAccount(OpenAccountInfo openAccountInfo) throws MaBizException ;

}
