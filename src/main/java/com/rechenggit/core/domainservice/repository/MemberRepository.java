package com.rechenggit.core.domainservice.repository;

import com.rechenggit.core.dal.dataobject.Member;

public interface MemberRepository {

    /**
     * 个人会员领域对象持久化 &lt;集成创建个人会员时使用&gt;
     * @param member
     * @param defaultOperator 默认操作员
     * @return
     * @throws MaBizException
     */
    //Member store(PersonalMember member, Operator defaultOperator) throws MaBizException;
    /**
     * 加载会员基础信息
     * <li>会员基本信息</li>
     * <li>个人/企业信息</li>
     * <li>会员标识</li>
     * @param memberId
     * @return
     */
    Member load(String memberId);
}
