package com.rechenggit.web;

import com.alibaba.fastjson.JSONObject;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import com.rechenggit.core.domain.EnterpriseOther;
import com.rechenggit.core.domainservice.service.EnterpriseMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/enterpriseMember")
public class EnterPriseMemberControl extends BaseControl {

    private final static Logger logger = LoggerFactory.getLogger(EnterPriseMemberControl.class);
    @Autowired
    private EnterpriseMemberService enterpriseMemberService;


    @PostMapping("/saveServiceInfo")
    public BaseResponse saveEnterpriseServiceInfo(@RequestBody @Validated EnterpriseMemberServiceDomain enterpriseMemberServiceDomain, BindingResult result) {
        BaseResponse<EnterpriseMemberServiceDomain> response=new BaseResponse();
        try{
            validate(result);
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
    public BaseResponse updateEnterpriseBasicInfo(@RequestBody @Validated EnterpriseBasic enterpriseBasic ,BindingResult result) {
        BaseResponse<EnterpriseBasic> response = new BaseResponse();
        try{
            validate(result);
            logger.info("更新enterpriseBasic:"+ JSONObject.toJSONString(enterpriseBasic));
            response = enterpriseMemberService.updateEnterpriseBasicInfo(enterpriseBasic);
        }catch (Exception e){
            logger.error("更新基本信息错误：{}",e);
            return  fail(response);
        }
        return response;
    }

    @PostMapping("/saveEnterpriseBasicInfo")
    public BaseResponse saveEnterpriseBasicInfo(@RequestBody @Validated EnterpriseBasic enterpriseBasic ,BindingResult result) {
        BaseResponse<EnterpriseBasic> response = new BaseResponse();
        try{
            validate(result);
            logger.info("保存enterpriseBasic:"+ JSONObject.toJSONString(enterpriseBasic));
            response = enterpriseMemberService.saveEnterpriseBasicInfo(enterpriseBasic);
        }catch (Exception e){
            logger.error("保存基本信息错误：{}",e);
            return  fail(response);
        }
        return response;
    }

    @RequestMapping("/queryEnterpriseBasicInfo")
    public BaseResponse queryEnterpriseBasicInfo(String memberId) {
        BaseResponse<EnterpriseBasic> response = new BaseResponse();
        if(memberId == null || "".equals(memberId) ){
            return new BaseResponse(501,"没有商户ID，操作失败");
        }
        try{
            response = enterpriseMemberService.queryEnterpriseBasicInfo(memberId);
        }catch (Exception e){
            logger.error("查询商户信息失败：{}",e);
            return  fail();
        }
        return success(response);
    }
    @RequestMapping("/deleteEnterpriseBasicInfo")
    public BaseResponse deleteEnterpriseBasicInfo(String memberId) {
        BaseResponse<EnterpriseBasic> response = new BaseResponse();
        try{
            logger.info("删除基本信息 memberId:"+ memberId);
            response = enterpriseMemberService.deleteEnterpriseBasicInfo(memberId);
        }catch (Exception e){
            logger.error("删除基本信息错误：{}",e);
            return  fail(response);
        }
        return response;
    }
    @PostMapping("/saveEnterpriseOtherInfo")
    public BaseResponse saveEnterpriseOtherInfo(@RequestBody @Validated EnterpriseOther enterpriseOther ,BindingResult result) {
        BaseResponse<EnterpriseOther> response = new BaseResponse();
        try{
            validate(result);
            logger.info("保存enterpriseOther:"+ JSONObject.toJSONString(enterpriseOther));
            response = enterpriseMemberService.saveEnterpriseOtherInfo(enterpriseOther);
        }catch (Exception e){
            logger.error("保存信息错误：{}",e);
            return  fail(response);
        }
        return response;
    }

    @RequestMapping("/queryEnterpriseOtherInfo")
    public BaseResponse queryEnterpriseOtherInfo(String memberId) {
        BaseResponse<EnterpriseOther> response = new BaseResponse();
        if(memberId == null || "".equals(memberId) ){
            return new BaseResponse(501,"没有商户ID，操作失败");
        }
        try{
            response = enterpriseMemberService.queryEnterpriseOtherInfo(memberId);
        }catch (Exception e){
            logger.error("查询商户信息失败：{}",e);
            return  fail();
        }
        return success(response);
    }
    @RequestMapping("/deleteEnterpriseOtherInfo")
    public BaseResponse deleteEnterpriseOtherInfo(String memberId) {
        BaseResponse<EnterpriseOther> response = new BaseResponse();
        try{
            logger.info("删除基本信息 memberId:"+ memberId);
            response = enterpriseMemberService.deleteEnterpriseOtherInfo(memberId);
        }catch (Exception e){
            logger.error("删除基本信息错误：{}",e);
            return  fail(response);
        }
        return response;
    }
}
