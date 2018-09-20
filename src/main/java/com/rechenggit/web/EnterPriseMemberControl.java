package com.rechenggit.web;

import com.alibaba.fastjson.JSONObject;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import com.rechenggit.core.domain.EnterpriseOther;
import com.rechenggit.core.domainservice.service.MemberService;
import com.rechenggit.core.exception.ValidateException;
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
    private MemberService memberService;


    @PostMapping("/saveServiceInfo")
    public BaseResponse saveEnterpriseServiceInfo(@RequestBody @Validated EnterpriseMemberServiceDomain enterpriseMemberServiceDomain, BindingResult result) {
        BaseResponse<EnterpriseMemberServiceDomain> response=new BaseResponse();
        try{
            validate(result);
            memberService.saveEnterpriseServiceInfo(enterpriseMemberServiceDomain);

        }catch (ValidateException e){
            logger.error("保存会员服务信息错误：{}",e.getMessage());
            response.setStatus(501);
            response.setMessage(e.getMessage());
            return  fail(response);

        }catch (Exception e){
            return  fail();
        }
        return success();

    }
    @GetMapping("/queryServiceInfo")
    public BaseResponse queryEnterpriseServiceInfoById(String memberId) {
        BaseResponse<EnterpriseMemberServiceDomain> response=new BaseResponse();
        try{
            EnterpriseMemberServiceDomain enterpriseMemberServiceDomain = memberService.queryEnterpriseServiceInfoById(memberId);
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
            response = memberService.updateEnterpriseBasicInfo(enterpriseBasic);
        }catch (Exception e){
            logger.error("更新基本信息错误：{}",e);
            return  fail();
        }
        return success(response);
    }

    @PostMapping("/saveEnterpriseBasicInfo")
    public BaseResponse saveEnterpriseBasicInfo(@RequestBody @Validated EnterpriseBasic enterpriseBasic ,BindingResult result) {
        BaseResponse<EnterpriseBasic> response = new BaseResponse();
        try{
            validate(result);
            logger.info("保存enterpriseBasic:"+ JSONObject.toJSONString(enterpriseBasic));
            memberService.saveEnterpriseBasicInfo(enterpriseBasic);
        }catch (Exception e){
            logger.error("保存基本信息错误：{}",e);
            response.setStatus(504);
            response.setMessage(e.getMessage());
            return  fail(response);
        }
        return success();
    }

    @RequestMapping("/queryEnterpriseBasicInfo")
    public BaseResponse queryEnterpriseBasicInfo(String memberId) {
        BaseResponse<EnterpriseBasic> response = new BaseResponse();
        if(memberId == null || "".equals(memberId) ){
            return new BaseResponse(501,"parameter.invalid");
        }
        try{
            response = memberService.queryEnterpriseBasicInfo(memberId);
        }catch (Exception e){
            logger.error("查询商户信息失败：{}",e);
            return  fail();
        }
        return success(response);
    }
    @RequestMapping("/deleteEnterpriseBasicInfo")
    public BaseResponse deleteEnterpriseBasicInfo(String memberId) {
        try{
            logger.info("删除基本信息 memberId:"+ memberId);
            memberService.deleteEnterpriseBasicInfo(memberId);
        }catch (Exception e){
            logger.error("删除基本信息错误：{}",e);
            return  fail();
        }
        return success();
    }
    @PostMapping("/saveEnterpriseOtherInfo")
    public BaseResponse saveEnterpriseOtherInfo(@RequestBody @Validated EnterpriseOther enterpriseOther ,BindingResult result) {
        try{
            validate(result);
            logger.info("保存enterpriseOther:"+ JSONObject.toJSONString(enterpriseOther));
            memberService.saveEnterpriseOtherInfo(enterpriseOther);
        }catch (Exception e){
            logger.error("保存信息错误：{}",e);
            return  fail();
        }
        return success();
    }

    @RequestMapping("/queryEnterpriseOtherInfo")
    public BaseResponse queryEnterpriseOtherInfo(String memberId) {
        BaseResponse<EnterpriseOther> response = new BaseResponse();
        if(memberId == null || "".equals(memberId) ){
            fail(new BaseResponse(501,"parameter.invalid"));
        }
        try{
            response = memberService.queryEnterpriseOtherInfo(memberId);
        }catch (Exception e){
            logger.error("查询商户信息失败：{}",e);
            return  fail();
        }
        return success(response);
    }
    @RequestMapping("/deleteEnterpriseOtherInfo")
    public BaseResponse deleteEnterpriseOtherInfo(String memberId) {
        try{
            logger.info("删除基本信息 memberId:"+ memberId);
            memberService.deleteEnterpriseOtherInfo(memberId);
        }catch (Exception e){
            logger.error("删除基本信息错误：{}",e);
            return  fail();
        }
        return success();
    }
}
