package com.rechenggit.web;

import com.alibaba.fastjson.JSONObject;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/enterpriseMember")
public class EnterPriseMemberControl extends BaseControl {
    private final static Logger logger = LoggerFactory.getLogger(EnterPriseMemberControl.class);

    @PostMapping("/saveServiceInfo")
    public BaseResponse saveEnterpriseServiceInfo(@RequestBody EnterpriseBasic enterpriseBasic) {
        System.out.println("enterpriseBasic:"+ JSONObject.toJSONString(enterpriseBasic));
        System.out.println();
        return new BaseResponse();
    }
}
