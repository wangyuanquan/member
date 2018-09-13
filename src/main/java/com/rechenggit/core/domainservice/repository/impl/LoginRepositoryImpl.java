package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.Operator;
import com.rechenggit.core.dal.mapper.EnterpriseBasicInfoMapper;
import com.rechenggit.core.dal.mapper.MemberMapper;
import com.rechenggit.core.domain.AccountDomain;
import com.rechenggit.core.domain.enums.AccountCategoryEnum;
import com.rechenggit.core.domain.login.OperatorLoginPwdRequest;
import com.rechenggit.core.domainservice.repository.AccountRepository;
import com.rechenggit.core.domainservice.repository.LoginRepository;
import com.rechenggit.core.exception.MaBizException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class LoginRepositoryImpl implements LoginRepository {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public Member getMemberByIdentity(OperatorLoginPwdRequest request) {
        //返回会员对象基本信息 （会员标识 平台类型）
        Example exampleMember = new Example(Member.class);
        exampleMember.createCriteria().andEqualTo("identity", request.getEmail());
        List<Member> memberList = memberMapper.selectByExample(exampleMember);
        return memberList.get(0);
    }

    @Override
    public Operator getOperatorByPwd(String memberId , OperatorLoginPwdRequest request) {
        return null;
    }
}
