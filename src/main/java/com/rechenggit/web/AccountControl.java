package com.rechenggit.web;

import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.account.OpenAccountInfo;
import com.rechenggit.core.domainservice.service.AccountService;
import com.rechenggit.core.exception.MaBizException;
import com.rechenggit.core.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/account")
public class AccountControl extends BaseControl {
    private final static Logger logger = LoggerFactory.getLogger(AccountControl.class);
    @Autowired
    private AccountService accountService;

    @PostMapping("/openAccount")
    public BaseResponse openAccount(@RequestBody @Validated OpenAccountInfo openAccountInfo, BindingResult result) {
        BaseResponse response = new BaseResponse();
        try{
            validate(result);
            response = accountService.openAccount(openAccountInfo);
        }catch (ValidateException e){
            logger.error("开户信息参数验证失败",e.getMessage());
            response.setStatus(505);
            response.setMessage(e.getMessage());
            return  fail(response);
        }catch (MaBizException e) {
            logger.error(e.getMessage());
            return fail(new BaseResponse(e.getResponseCode().getCode(),e.getResponseCode().getMessage()));
        } catch (Exception e) {
            logger.error("开户异常 ", e);
            response.setStatus(500);
            response.setMessage(e.getMessage());
            return fail(response);
        }
        return success(response);
    }
}
