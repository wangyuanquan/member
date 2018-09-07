package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.mapper.MemberMapper;
import com.rechenggit.core.domainservice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @Resource
    MemberMapper memberMapper;

    @Override
    @Cacheable(value = "member", key = "#memberId")
    public Member load(String memberId) {
        Example example = new Example(Member.class);
        example.createCriteria().andEqualTo("memberId",memberId)
               ;
     List<Member> list= memberMapper.selectByExample(example);
        return memberMapper.selectByPrimaryKey(memberId);
    }
}
