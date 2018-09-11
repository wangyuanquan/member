package com.rechenggit.core.domainservice.mongodbrepository.impl;

import com.rechenggit.core.dal.mongodbobject.User;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import com.rechenggit.core.domainservice.mongodbrepository.MongoMemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoMemberRespositoryImpl implements MongoMemberRespository {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<EnterpriseMemberServiceDomain> findAll() {
        return mongoTemplate.findAll(EnterpriseMemberServiceDomain.class);
    }

    @Override
    public EnterpriseMemberServiceDomain getEnterpriseMemberService(String memberId) {
        return mongoTemplate.findOne(new Query(Criteria.where("memberId").is(memberId)), EnterpriseMemberServiceDomain.class);
    }

    @Override
    public void update(EnterpriseMemberServiceDomain enterpriseMemberServiceDomain) {
        Criteria criteria = Criteria.where("memberId").is(enterpriseMemberServiceDomain.getMemberId());
        Query query = new Query(criteria);
        Update update = Update.update("instorePaymentServie", enterpriseMemberServiceDomain.getInstorePaymentServie())
                .set("jsapiPaymentService",enterpriseMemberServiceDomain.getJsapiPaymentService())
                .set("webSitePaymentService",enterpriseMemberServiceDomain.getWebSitePaymentService())
                .set("instorePaymentServie",enterpriseMemberServiceDomain.getInstorePaymentServie())
                .set("weChatMallPaymentService",enterpriseMemberServiceDomain.getWeChatMallPaymentService()
        );
        mongoTemplate.updateMulti(query, update, EnterpriseMemberServiceDomain.class);
    }

    @Override
    public void insert(EnterpriseMemberServiceDomain enterpriseMemberServiceDomain) {
        Criteria criteria = Criteria.where("memberId").is(enterpriseMemberServiceDomain.getMemberId());
        Query query = new Query(criteria);

        if (mongoTemplate.findOne(query,EnterpriseMemberServiceDomain.class)!=null){

            Update update = Update.update("instorePaymentServie", enterpriseMemberServiceDomain.getInstorePaymentServie())
                    .set("webSitePaymentService",enterpriseMemberServiceDomain.getWebSitePaymentService())
                    .set("webSitePaymentServiveContent",enterpriseMemberServiceDomain.getWebSitePaymentServiveContent())
                    .set("jsapiPaymentService",enterpriseMemberServiceDomain.getJsapiPaymentService())
                    .set("jsapiPaymentServiceContent",enterpriseMemberServiceDomain.getJsapiPaymentServiceContent())
                    .set("instorePaymentServie",enterpriseMemberServiceDomain.getInstorePaymentServie())
                    .set("weChatMallPaymentService",enterpriseMemberServiceDomain.getWeChatMallPaymentService()
                    );
        }else {
            mongoTemplate.insert(enterpriseMemberServiceDomain);
        }


    }

    @Override
    public void insertAll(List<EnterpriseMemberServiceDomain> enterpriseMemberServiceDomains) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<EnterpriseMemberServiceDomain> findByPage(EnterpriseMemberServiceDomain enterpriseMemberServiceDomain, Pageable pageable) {
        return null;
    }

    @Override
    public EnterpriseMemberServiceDomain findOne(String memberId) {
        return mongoTemplate.findOne(new Query(Criteria.where("memberId").is(memberId)), EnterpriseMemberServiceDomain.class);
    }
}
