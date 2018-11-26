package com.anole.core.domainservice.repository;

import com.anole.core.common.BaseResponse;
import com.anole.core.dal.dataobject.UserInfo;

public interface LoginRepository {
    /**
     * 根据用户名查询用户信息
     * @return
     */
    UserInfo queryUserInfoByName(String loginName);

}
