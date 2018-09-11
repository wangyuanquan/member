package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;

public interface EnterpriseMemberDao {
    /**
     * 保存商户基本信息
     * @param enterpriseBasic
     */
    BaseResponse saveEnterpriseServiceInfo(EnterpriseBasic enterpriseBasic);
    /**
     * 更新商户基本信息
     * @param enterpriseBasic
     */
    BaseResponse updateEnterpriseServiceInfo(EnterpriseBasic enterpriseBasic);
    /**
     * 查询商户基本信息
     * @param memberId
     */
    EnterpriseBasic queryEnterpriseServiceInfo(String memberId);
    /**
     * 删除商户基本信息
     * @param memberId
     */
    BaseResponse deleteEnterpriseServiceInfo(String memberId);
}
