package com.anole.core.domainservice.repository.impl;

import com.anole.core.dal.dataobject.SettlementsInfo;
import com.anole.core.dal.mapper.SettlementsInfoMapper;
import com.anole.core.domain.settlements.EnterpriseSettlementInfo;
import com.anole.core.domain.settlements.Settlements;
import com.anole.core.domainservice.repository.SettlementRepository;
import com.anole.core.exception.MaBizException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SettlementRepositoryImpl implements SettlementRepository {
    @Autowired
    SettlementsInfoMapper settlementsInfoMapper;
    @Override
    public int saveRateInfo(String memberId,Settlements settlements) throws MaBizException{

        //tm_settlements_info 保存 费率信息
        Example exampleSettlementsInfo = new Example(SettlementsInfo.class);
        exampleSettlementsInfo.createCriteria().andEqualTo("memberId", memberId)
                .andEqualTo("settlementType", settlements.getSettlementType());
        List<SettlementsInfo> settlementInfoList = settlementsInfoMapper.selectByExample(exampleSettlementsInfo);
        SettlementsInfo settlementsInfo = new SettlementsInfo();
        BeanUtils.copyProperties(settlements,settlementsInfo);
        int result;
        if(settlementInfoList.isEmpty()){
            settlementsInfo.setCreateTime(new Date());
            result = settlementsInfoMapper.insertSelective(settlementsInfo);
        }else{
            result = settlementsInfoMapper.updateByExampleSelective(settlementsInfo,exampleSettlementsInfo);
        }
        return result;
    }

    @Override
    public EnterpriseSettlementInfo queryRateInfo(String memberId) throws MaBizException {
        EnterpriseSettlementInfo enterpriseSettlementInfo = new EnterpriseSettlementInfo();
        //tm_settlements_info  汇率信息
        Example exampleSettlementsInfo = new Example(SettlementsInfo.class);
        exampleSettlementsInfo.createCriteria().andEqualTo("memberId", memberId);
        List<SettlementsInfo> settlementInfoList = settlementsInfoMapper.selectByExample(exampleSettlementsInfo);
        List<Settlements>  settlementsList = new ArrayList<>();
        for(SettlementsInfo settlementsInfo:settlementInfoList){
            Settlements settlements = new Settlements();
            BeanUtils.copyProperties(settlementsInfo,settlements);
            settlementsList.add(settlements);
        }
        enterpriseSettlementInfo.setSettlements(settlementsList);
        return enterpriseSettlementInfo;
    }
}
