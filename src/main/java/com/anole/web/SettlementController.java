package com.anole.web;

import com.anole.core.common.BaseResponse;
import com.anole.core.domain.settlements.EnterpriseSettlementInfo;
import com.anole.core.domainservice.service.SettlementService;
import com.anole.core.exception.MaBizException;
import com.anole.core.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/settlement")
public class SettlementController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(SettlementController.class);
    @Autowired
    private SettlementService settlementService;

    @PostMapping("/saveRateInfo")
    public BaseResponse saveRateInfo(@RequestBody @Validated EnterpriseSettlementInfo enterpriseSettlementInfo, BindingResult result) {
        BaseResponse response = new BaseResponse();
        try{
            validate(result);
            response = settlementService.saveRateInfo(enterpriseSettlementInfo);
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
        return success(response);
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
