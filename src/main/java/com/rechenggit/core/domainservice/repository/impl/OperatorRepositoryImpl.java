package com.rechenggit.core.domainservice.repository.impl;

import com.netfinworks.common.lang.StringUtil;
import com.rechenggit.core.dal.dataobject.LoginName;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.dal.mapper.LoginNameMapper;
import com.rechenggit.core.dal.mapper.OperatorMapper;
import com.rechenggit.core.domain.enums.PlatFormTypeEnum;
import com.rechenggit.core.domainservice.repository.OperatorRepository;
import com.rechenggit.core.exception.MaIllegalArgumentException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Repository
public class OperatorRepositoryImpl implements OperatorRepository {
    @Autowired
    OperatorMapper operatorMapper;
    @Autowired
    LoginNameMapper loginNameMapper;
    @Override
    public String queryOperatorIdByLoginName(String memberId, String loginName, Integer platFormType)throws MaIllegalArgumentException {

        if (StringUtil.isEmpty(memberId) || StringUtil.isEmpty(loginName)) {
            throw new MaIllegalArgumentException("memberId与loginName不能为空");
        }
        int pid = platFormType == null ? PlatFormTypeEnum.DEFAULT.getCode() : platFormType
                .intValue();
        Example example =new Example(LoginName.class);
        example.createCriteria()
                .andEqualTo("memberId",memberId)
                .andEqualTo("loginName",loginName)
                .andEqualTo("sourceType",pid);


        List<LoginName> loginNameList =  loginNameMapper.selectByExample(example);
       // TrLoginNameDO loginNameDo = loginNameMapper.getLoginName(memberId, loginName, pid);
        if (CollectionUtils.isNotEmpty(loginNameList)) {
            return loginNameList.get(0).getOperatorId();
        }
        return null;
    }

    @Override
    public Operator loadByOperatorId(String operatorId) {
        Example example =new Example(Operator.class);
        example.createCriteria().andEqualTo("operatorId",operatorId);

        Operator operator =operatorMapper.selectOneByExample(example);

        return operator;
    }
}
