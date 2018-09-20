package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseOther;
import com.rechenggit.core.domain.PayPwdRequest;

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
    BaseResponse queryEnterpriseBasicInfo(String memberId);
    /**
     * 删除商户基本信息
     * @param memberId
     */
    BaseResponse deleteEnterpriseBasicInfo(String memberId);
    /**
     * 保存商户其他信息
     * @param enterpriseOther
     */
    BaseResponse saveEnterpriseOtherInfo(EnterpriseOther enterpriseOther);
    /**
     * 查询商户其他信息
     * @param memberId
     */
    BaseResponse queryEnterpriseOtherInfo(String memberId);
    /**
     * 删除商户其他信息
     * @param memberId
     */
    BaseResponse deleteEnterpriseOtherInfo(String memberId);

    /**
     * 校验支付密码
     * @param payPwdRequest
     * @return
     */
    BaseResponse verifyPayPwd(PayPwdRequest payPwdRequest);
}
