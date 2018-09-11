package com.rechenggit.core.domainservice.service.impl;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.dal.mongodbobject.User;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domainservice.mongodbrepository.UserRepository;
import com.rechenggit.core.domainservice.service.EnterpriseMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EnterpriseMemberServiceImpl implements EnterpriseMemberService {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public BaseResponse saveEnterpriseServiceInfo(EnterpriseBasic enterpriseBasic) {

        return new BaseResponse();
    }
}
