package com.rechenggit.core.domainservice.validator;

import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.exception.MaBizException;

public interface OperatorValidator {
    Operator validateOperatorExistAndNormal(String memberId, String loginName, Integer platFormType)throws MaBizException;

    void validateLoginPassWord(String password)throws MaBizException;
}
