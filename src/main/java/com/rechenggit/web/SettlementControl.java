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
        try{
            validate(result);
            settlementService.saveRateInfo(enterpriseSettlementInfo);
        }catch (MaBizException e) {
            logger.error(e.getMessage());
            return fail(new BaseResponse(e.getCode().getCode(),e.getCode().getMessage()));
        } catch (Exception e) {
            logger.error("保存汇率信息:异常 ", e);
            return fail();
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
            return fail(new BaseResponse(e.getCode().getCode(),e.getCode().getMessage()));
        } catch (Exception e) {
            logger.error("商家汇率查询:异常 ", e);
            return fail();
        }
        return success(response);
    }
}
