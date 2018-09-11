package com.rechenggit.web;

import com.alibaba.fastjson.JSONObject;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import com.rechenggit.core.domainservice.service.EnterpriseMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/saveServiceInfo")
    public BaseResponse saveEnterpriseServiceInfo(@RequestBody @Validated EnterpriseMemberServiceDomain enterpriseMemberServiceDomain) {
        BaseResponse<EnterpriseMemberServiceDomain> response=new BaseResponse();
        try{
            enterpriseMemberService.saveEnterpriseServiceInfo(enterpriseMemberServiceDomain);

        }catch (Exception e){
            logger.error("保存会员服务信息错误：{}",e);
            return  fail(response);

        }
        return success();

    }
    @GetMapping("/queryServiceInfo")
    public BaseResponse queryEnterpriseServiceInfoById(String memberId) {
        BaseResponse<EnterpriseMemberServiceDomain> response=new BaseResponse();
        try{
            EnterpriseMemberServiceDomain enterpriseMemberServiceDomain=    enterpriseMemberService.queryEnterpriseServiceInfoById(memberId);
            response.setData(enterpriseMemberServiceDomain);
        }catch (Exception e){
            logger.error("查询会员服务信息错误：{}",e);
            return  fail();

        }
        return success(response);

    }

    @PostMapping("/updateEnterpriseBasicInfo")
    public BaseResponse updateEnterpriseBasicInfo(@RequestBody EnterpriseBasic enterpriseBasic) {

        logger.info("保存enterpriseBasic:"+ JSONObject.toJSONString(enterpriseBasic));

        return enterpriseMemberService.updateEnterpriseBasicInfo(enterpriseBasic);
    }

    @PostMapping("/queryEnterpriseBasicInfo")
    public EnterpriseBasic queryEnterpriseBasicInfo(@RequestBody String memberId) {

        return enterpriseMemberService.queryEnterpriseBasicInfo(memberId);
    }
    @PostMapping("/queryEnterpriseBasicInfo")
    public BaseResponse deleteEnterpriseBasicInfo(@RequestBody String memberId) {

        return enterpriseMemberService.deleteEnterpriseBasicInfo(memberId);
    }
}
