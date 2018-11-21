package com.anole.core.domainservice.service;

import com.anole.core.common.BaseResponse;
import com.anole.core.domain.settlements.EnterpriseSettlementInfo;
import com.anole.core.exception.MaBizException;

public interface SettlementService {

    /**
     * 保存汇率信息 后台
     * @return
     */
    BaseResponse saveRateInfo(EnterpriseSettlementInfo enterpriseSettlementInfo) throws MaBizException ;
    /**
     * 保存汇率信息 商户 只能修改consumer
     * @return
     */
    BaseResponse saveConsumerRateInfo(EnterpriseSettlementInfo enterpriseSettlementInfo) throws MaBizException ;
    /**
     * 查询汇率信息
     * @return
     */
    EnterpriseSettlementInfo queryRateInfo(String memberId) throws MaBizException;

}
