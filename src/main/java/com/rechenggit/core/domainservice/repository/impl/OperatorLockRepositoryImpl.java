package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.dal.dataobject.PwdOperatorLock;
import com.rechenggit.core.dal.mapper.OperatorMapper;
import com.rechenggit.core.dal.mapper.PwdOperatorLockMapper;
import com.rechenggit.core.domain.PassWordLock;
import com.rechenggit.core.domain.enums.PassWordLockFlagEnum;
import com.rechenggit.core.domainservice.repository.OperatorLockRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

@Repository
public class OperatorLockRepositoryImpl implements OperatorLockRepository {
    @Resource
    OperatorMapper operatorMapper;
    @Resource
    PwdOperatorLockMapper pwdOperatorLockMapper;
    @Override
    public long getCountLock(String operatorId, PassWordLockFlagEnum flag) {
        Example example =new Example(PwdOperatorLock.class);
        example.createCriteria()
                .andEqualTo("operatorId",operatorId)
                .andEqualTo("flag",flag.getCode());
       return pwdOperatorLockMapper.selectCountByExample(example);

    }

    @Override
    public void reStore(PassWordLock passWordLock) {
        Example example =new Example(PwdOperatorLock.class);
        example.createCriteria()
                .andEqualTo("operatorId",passWordLock.getOperatorId())
                .andEqualTo("accountId",passWordLock.getAccountId())
                .andEqualTo("flag",passWordLock.getFlag())
                .andEqualTo("status",passWordLock.getStatus());
        PwdOperatorLock update =new PwdOperatorLock();
        update.setStatus(0);
        update.setUpdateTime(new Date());
        pwdOperatorLockMapper.updateByExampleSelective(update,example);


    }
}
