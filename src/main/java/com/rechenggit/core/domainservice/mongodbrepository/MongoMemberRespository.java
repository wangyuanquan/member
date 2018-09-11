package com.rechenggit.core.domainservice.mongodbrepository;

import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MongoMemberRespository {
    List<EnterpriseMemberServiceDomain> findAll();

    EnterpriseMemberServiceDomain getEnterpriseMemberService(String id);

    void update(EnterpriseMemberServiceDomain user);

    void insert(EnterpriseMemberServiceDomain user);

    void insertAll(List<EnterpriseMemberServiceDomain> enterpriseMemberServiceDomains);

    void remove(String id);

    List<EnterpriseMemberServiceDomain> findByPage(EnterpriseMemberServiceDomain enterpriseMemberServiceDomain, Pageable pageable);

    EnterpriseMemberServiceDomain findOne(String memberId);
}
