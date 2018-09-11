package com.rechenggit.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class EnterpriseMemberServiceDomain extends BaseMember {
    @NotNull(message="{instorePaymentServie.empty.error}")
    private Boolean instorePaymentServie;

    @NotNull(message="{webSitePaymentService.empty.error}")
    private Boolean webSitePaymentService;


    @NotNull(message="{webSitePaymentServiveContent.empty.error}")
    private WebSitePaymentServiveContent webSitePaymentServiveContent;
    @NotNull(message="{jsapiPaymentService.empty.error}")
    private Boolean jsapiPaymentService;
    private JSAPIPaymentServiceContent jsapiPaymentServiceContent;


    @NotNull(message="{weChatMallPaymentService.empty.error}")
    private Boolean weChatMallPaymentService;
}
