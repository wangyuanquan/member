package com.rechenggit.core.domainservice.validator;

import com.rechenggit.core.common.LoginRequest;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.domain.BaseMember;
import com.rechenggit.core.exception.MaBizException;
import org.springframework.stereotype.Service;

@Service
public interface MemberValidator {

    Member validateMemberExistAndNormal(String identity, Integer platFormType) throws MaBizException;
}
