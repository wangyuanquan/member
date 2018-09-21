package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.settlements.EnterpriseSettlementInfo;
import com.rechenggit.core.domainservice.repository.SettlementRepository;
import com.rechenggit.core.exception.MaBizException;
import org.springframework.stereotype.Repository;

@Repository
public class SettlementRepositoryImpl implements SettlementRepository {
    @Override
    public BaseResponse saveRateInfo(EnterpriseSettlementInfo enterpriseSettlementInfo) throws MaBizException {
        return null;
    }

    @Override
    public EnterpriseSettlementInfo queryRateInfo(String memberId) throws MaBizException {
        return null;
    }
}
