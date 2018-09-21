package com.rechenggit.web;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import com.rechenggit.core.domain.PayPwdRequest;
import com.rechenggit.core.domainservice.service.MemberService;
import com.rechenggit.core.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/member")
public class MemberControl extends BaseControl {

    private final static Logger logger = LoggerFactory.getLogger(MemberControl.class);
    @Autowired
    private MemberService memberService;


    @PostMapping("/verifyPayPwd")
    public BaseResponse verifyPayPwd(@RequestBody @Validated PayPwdRequest payPwdRequest, BindingResult result) {
        BaseResponse response=new BaseResponse();
        try{
            validate(result);
            response = memberService.verifyPayPwd(payPwdRequest);

        }catch (ValidateException e){
            logger.error("保存会员服务信息错误：{}",e.getMessage());
            response.setStatus("501");
            response.setMessage(e.getMessage());
            return  fail(response);

        }catch (Exception e){
            logger.error("verifyPayPwd has  Exception req 【{}】",payPwdRequest,e);
            return  fail();
        }
        return success(response);

    }

}
