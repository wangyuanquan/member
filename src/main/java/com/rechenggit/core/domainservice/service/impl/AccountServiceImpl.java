package com.rechenggit.core.domainservice.service.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.domain.account.OpenAccountInfo;
import com.rechenggit.core.domain.enums.MemberStatusEnum;
import com.rechenggit.core.domain.enums.ResponseCode;
import com.rechenggit.core.domainservice.repository.AccountRepository;
import com.rechenggit.core.domainservice.repository.MemberRepository;
import com.rechenggit.core.domainservice.service.AccountService;
import com.rechenggit.core.exception.MaBizException;
import com.rechenggit.web.EnterPriseMemberControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountServiceImpl implements AccountService {
    private final static Logger logger = LoggerFactory.getLogger(EnterPriseMemberControl.class);
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public BaseResponse openAccount(OpenAccountInfo openAccountInfo) throws MaBizException {
        String memberId = openAccountInfo.getMemberId();
        Long accountType = openAccountInfo.getAccountType();
        //验证会员存在未注销
        Member member = memberRepository.load(memberId);
        if (member.getStatus() == MemberStatusEnum.CANCEL.getCode()) {
            throw new MaBizException(ResponseCode.MEMBER_CANCELLED, "会员编号为" + memberId + "的会员已注销。");
        }
        //验证会员类型和账户类型是否匹配
        //补别名
        //设置创建会员账户关系
        /////需要其他信息
        //开户
        //String accountId = accountRepository.openAccount(openAccountInfo);
        BaseResponse BaseResponse = new BaseResponse();
        return BaseResponse;
    }
}
