package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.MemberIdentity;
import com.rechenggit.core.dal.mapper.MemberIdentityMapper;
import com.rechenggit.core.dal.mapper.MemberMapper;
import com.rechenggit.core.domain.MemberIntegratedQuery;
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
    @Resource
    MemberIdentityMapper memberIdentityMapper;

    @Override
    @Cacheable(value = "member", key = "#memberId")
    public Member load(String memberId) {
        Example example = new Example(Member.class);
        example.createCriteria().andEqualTo("memberId",memberId)
               ;
     List<Member> list= memberMapper.selectByExample(example);
        return memberMapper.selectByPrimaryKey(memberId);
    }

    @Override
    public Member queryBaseMember(MemberIntegratedQuery query) {
        Example example =new Example(MemberIdentity.class);
        example.createCriteria()
                .andEqualTo("identity",query.getMemberIdentity())
                .andEqualTo("pid",query.getPlatformType());
        MemberIdentity memberIdentity=  memberIdentityMapper.selectOneByExample(example);
        return load(memberIdentity.getMemberId());
        //return
    }
}
