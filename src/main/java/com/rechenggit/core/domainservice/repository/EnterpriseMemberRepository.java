package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;

public interface EnterpriseMemberRepository {
    /**
     * 保存商户基本信息
     * @param enterpriseBasic
     */
    BaseResponse saveEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic);
    /**
     * 更新商户基本信息
     * @param enterpriseBasic
     */
    BaseResponse updateEnterpriseBasicInfo(EnterpriseBasic enterpriseBasic);
    /**
     * 查询商户基本信息
     * @param memberId
     */
    EnterpriseBasic queryEnterpriseBasicInfo(String memberId);
    /**
     * 删除商户基本信息
     * @param memberId
     */
    BaseResponse deleteEnterpriseBasicInfo(String memberId);
}