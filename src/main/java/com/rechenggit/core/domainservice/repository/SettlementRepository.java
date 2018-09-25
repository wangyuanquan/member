package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.settlements.EnterpriseSettlementInfo;
import com.rechenggit.core.exception.MaBizException;

public interface SettlementRepository {
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
