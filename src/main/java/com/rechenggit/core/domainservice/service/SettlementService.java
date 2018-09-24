package com.rechenggit.core.domainservice.service;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.domain.login.*;
import com.rechenggit.core.domain.settlements.EnterpriseSettlementInfo;
import com.rechenggit.core.exception.ErrorCodeException.CommonException;
import com.rechenggit.core.exception.MaBizException;

public interface SettlementService {

    /**
     * 保存汇率信息
     * @return
     */
    int saveRateInfo(EnterpriseSettlementInfo enterpriseSettlementInfo) throws MaBizException ;
    /**
     * 查询汇率信息
     * @return
     */
    EnterpriseSettlementInfo queryRateInfo(String memberId) throws MaBizException;

}
