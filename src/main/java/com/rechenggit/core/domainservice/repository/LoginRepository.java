package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.domain.AccountDomain;
import com.rechenggit.core.domain.enums.AccountCategoryEnum;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;
import com.rechenggit.core.exception.MaBizException;

import java.util.List;

public interface LoginRepository {
    /**
     * 查询会员 通过标识
     * @param request
     */
    Member getMemberByIdentity(OperatorLoginPwdRequest request);

    /**
     * 查询操作员 通过用户 密码
     * @param request
     */
    Operator getOperatorByPwd(String memberId , OperatorLoginPwdRequest request);
}
