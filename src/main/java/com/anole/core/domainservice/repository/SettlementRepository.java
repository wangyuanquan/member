package com.anole.core.domainservice.repository;

import com.anole.core.common.BaseResponse;
import com.anole.core.domain.settlements.EnterpriseSettlementInfo;
import com.anole.core.domain.settlements.Settlements;
import com.anole.core.exception.MaBizException;

public interface SettlementRepository {
    /**
     * 保存汇率信息
     * @return
     */
    int saveRateInfo(String memberId,Settlements settlements) throws MaBizException ;
    /**
     * 查询汇率信息
     * @return
     */
    EnterpriseSettlementInfo queryRateInfo(String memberId) throws MaBizException;

}
