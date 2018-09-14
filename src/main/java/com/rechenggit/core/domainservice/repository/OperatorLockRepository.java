package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.domain.PassWordLock;
import com.rechenggit.core.domain.enums.PassWordLockFlagEnum;

public interface OperatorLockRepository {
    long getCountLock(String operatorId, PassWordLockFlagEnum flag);

    void reStore(PassWordLock passWordLock);
}
