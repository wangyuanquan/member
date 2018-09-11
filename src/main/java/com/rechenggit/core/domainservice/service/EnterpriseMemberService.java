package com.rechenggit.core.domainservice.service;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;

public interface EnterpriseMemberService {
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

    void saveEnterpriseServiceInfo(EnterpriseMemberServiceDomain enterpriseMemberServiceDomain);

    EnterpriseMemberServiceDomain queryEnterpriseServiceInfoById(String memberId);
}
