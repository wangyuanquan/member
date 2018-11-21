package com.anole.core.domainservice.service.impl;

import com.anole.core.common.BaseResponse;
import com.anole.core.domain.settlements.EnterpriseSettlementInfo;
import com.anole.core.domain.settlements.Settlements;
import com.anole.core.domainservice.repository.SettlementRepository;
import com.anole.core.domainservice.service.SettlementService;
import com.anole.core.exception.MaBizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SettlementServiceImpl implements SettlementService {
    @Autowired
    private SettlementRepository settlementRepository;

    @Override
    @Transactional
    public BaseResponse saveRateInfo(EnterpriseSettlementInfo enterpriseSettlementInfo) throws MaBizException {
        for(Settlements settlements :enterpriseSettlementInfo.getSettlements()){
            int result = settlementRepository.saveRateInfo(enterpriseSettlementInfo.getMemberId(),settlements);
            if(result == 0){
                return new BaseResponse(500,"unknown");
            }
        }
        return new BaseResponse();
    }
    @Override
    @Transactional
    public BaseResponse saveConsumerRateInfo(EnterpriseSettlementInfo enterpriseSettlementInfo) throws MaBizException {
        for(Settlements settlements :enterpriseSettlementInfo.getSettlements()){
            //防止请求注入
            if(settlements.getSettlementType() != 2){
                return new BaseResponse(500,"parameter.invalid");
            }
            int result = settlementRepository.saveRateInfo(enterpriseSettlementInfo.getMemberId(),settlements);
            if(result == 0){
                return new BaseResponse(500,"unknown");
            }
        }
        return new BaseResponse();
    }

    @Override
    public EnterpriseSettlementInfo queryRateInfo(String memberId) throws MaBizException {
        return settlementRepository.queryRateInfo(memberId);
    }
}
