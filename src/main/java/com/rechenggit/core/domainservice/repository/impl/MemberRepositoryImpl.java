package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.mapper.MemberMapper;
import com.rechenggit.core.domainservice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @Resource
    MemberMapper memberMapper;

    @Override
    @Cacheable(value = "member", key = "#memberId")
    public Member load(String memberId) {
        return memberMapper.selectByPrimaryKey(memberId);
    }
}
