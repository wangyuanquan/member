package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.dal.dataobject.Operator;

public interface OperatorRepository {
    String queryOperatorIdByLoginName(String memberId, String loginName, Integer platFormType);

    Operator loadByOperatorId(String operatorId);
}
