package com.rechenggit.web;

import com.alibaba.fastjson.JSONObject;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domainservice.mongodbrepository.UserRepository;
import com.rechenggit.core.domainservice.service.EnterpriseMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/enterpriseMember")
public class EnterPriseMemberControl extends BaseControl {

    private final static Logger logger = LoggerFactory.getLogger(EnterPriseMemberControl.class);
    @Autowired
    private EnterpriseMemberService enterpriseMemberService;

    @PostMapping("/saveEnterpriseBasicInfo")
    public BaseResponse saveEnterpriseBasicInfo(@RequestBody EnterpriseBasic enterpriseBasic) {

        logger.info("保存enterpriseBasic:"+ JSONObject.toJSONString(enterpriseBasic));

        return enterpriseMemberService.saveEnterpriseBasicInfo(enterpriseBasic);
    }

    @PostMapping("/updateEnterpriseBasicInfo")
    public BaseResponse updateEnterpriseBasicInfo(@RequestBody EnterpriseBasic enterpriseBasic) {

        logger.info("保存enterpriseBasic:"+ JSONObject.toJSONString(enterpriseBasic));

        return enterpriseMemberService.updateEnterpriseBasicInfo(enterpriseBasic);
    }
}
