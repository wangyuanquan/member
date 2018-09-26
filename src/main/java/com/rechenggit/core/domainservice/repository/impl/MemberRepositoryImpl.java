package com.rechenggit.core.domainservice.repository.impl;

import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.dataobject.MemberIdentity;
import com.rechenggit.core.dal.mapper.MemberIdentityMapper;
import com.rechenggit.core.dal.mapper.MemberMapper;
import com.rechenggit.core.domain.MemberIntegratedQuery;
import com.rechenggit.core.domain.enums.ResponseCode;
import com.rechenggit.core.domainservice.repository.MemberRepository;
import com.rechenggit.core.exception.MaBizException;
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
    public Member load(String memberId) throws MaBizException{
        Member member = memberMapper.selectByPrimaryKey(memberId);
        if(member == null){
            throw new MaBizException(ResponseCode.ARGUMENT_ERROR,
                    "tm_member表中memberId" + memberId + "的相关信息不存在");
        }
        return member;
    }

    @Override
    public Member queryBaseMember(MemberIntegratedQuery query)throws MaBizException{
        Example example =new Example(MemberIdentity.class);
        example.createCriteria()
                .andEqualTo("identity",query.getMemberIdentity())
                .andEqualTo("pid",query.getPlatformType());
        MemberIdentity memberIdentity=  memberIdentityMapper.selectOneByExample(example);
        if (memberIdentity == null){
          return  null;
        }
        return load(memberIdentity.getMemberId());
        //return
    }
}
