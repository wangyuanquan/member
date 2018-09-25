package com.rechenggit.core.domainservice.service.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.settlements.EnterpriseSettlementInfo;
import com.rechenggit.core.domain.settlements.Settlements;
import com.rechenggit.core.domainservice.repository.LoginRepository;
import com.rechenggit.core.domainservice.repository.SettlementRepository;
import com.rechenggit.core.domainservice.service.SettlementService;
import com.rechenggit.core.exception.MaBizException;
import com.rechenggit.web.EnterPriseMemberControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SettlementServiceImpl implements SettlementService {
    private final static Logger logger = LoggerFactory.getLogger(EnterPriseMemberControl.class);
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
    public EnterpriseSettlementInfo queryRateInfo(String memberId) throws MaBizException {
        return settlementRepository.queryRateInfo(memberId);
    }
}
