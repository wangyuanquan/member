package com.rechenggit.core.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class MemberIntegratedQuery {
    /** 会员编号*/
    private String     memberId;
    /** 会员标识*/
    private String     memberIdentity;
    /** 会员所属平台类型（0默认：微汇平台， 1：新浪微博）*/
    private int        platformType;
    /** 是否需要查询认证信息*/
    private boolean    requireVerifyInfos;
    /** 是否需要查询默认操作员*/
    private boolean    requireDefaultOperator;
    /** 账户查询信息*/
    private boolean    requireAccountInfos;
    /**要查询的账户类型，当RequireAccounts为true时有效，空代表查询所有账户类型 */
    private List<Long> accountTypes;
}
