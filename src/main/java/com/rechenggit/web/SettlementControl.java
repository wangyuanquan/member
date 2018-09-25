package com.rechenggit.web;

import com.alibaba.fastjson.JSONObject;
import com.rechenggit.core.common.BaseResponse;
import com.rechenggit.core.domain.EnterpriseBasic;
import com.rechenggit.core.domain.EnterpriseMemberServiceDomain;
import com.rechenggit.core.domain.EnterpriseOther;
import com.rechenggit.core.domain.settlements.EnterpriseSettlementInfo;
import com.rechenggit.core.domainservice.service.MemberService;
import com.rechenggit.core.domainservice.service.SettlementService;
import com.rechenggit.core.exception.MaBizException;
import com.rechenggit.core.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/settlement")
public class SettlementControl extends BaseControl {

    private final static Logger logger = LoggerFactory.getLogger(SettlementControl.class);
    @Autowired
    private SettlementService settlementService;

    @PostMapping("/saveRateInfo")
    public BaseResponse saveRateInfo(@RequestBody @Validated EnterpriseSettlementInfo enterpriseSettlementInfo, BindingResult result) {
        BaseResponse response = new BaseResponse();
        try{
            validate(result);
            int state = settlementService.saveRateInfo(enterpriseSettlementInfo);
            if(state == 0){
                return fail();
            }
        }catch (ValidateException e){
            logger.error("保存汇率信息参数验证失败",e.getMessage());
            response.setStatus(505);
            response.setMessage(e.getMessage());
            return  fail(response);
        }catch (MaBizException e) {
            logger.error(e.getMessage());
            return fail(new BaseResponse(e.getResponseCode().getCode(),e.getResponseCode().getMessage()));
        } catch (Exception e) {
            logger.error("保存汇率信息:异常 ", e);
            response.setStatus(500);
            response.setMessage(e.getMessage());
            return fail(response);
        }
        return success();

    }
    @GetMapping("/queryRateInfo")
    public BaseResponse queryRateInfo(String memberId) {
        BaseResponse response = new BaseResponse();
        try{
            EnterpriseSettlementInfo enterpriseSettlementInfo = settlementService.queryRateInfo(memberId);
            response.setData(enterpriseSettlementInfo);
        }catch (MaBizException e) {
            logger.error(e.getMessage());
            return fail(new BaseResponse(e.getResponseCode().getCode(),e.getResponseCode().getMessage()));
        } catch (Exception e) {
            logger.error("商家汇率查询:异常 ", e);
            response.setStatus(500);
            response.setMessage(e.getMessage());
            return fail(response);
        }
        return success(response);
    }
}
