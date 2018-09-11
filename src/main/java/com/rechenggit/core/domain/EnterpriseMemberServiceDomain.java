package com.rechenggit.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class EnterpriseMemberServiceDomain extends BaseMember {
    private String id;
    @NotNull(message="{instorePaymentServie.empty.error}")
    private Boolean instorePaymentServie;

    @NotNull(message="{webSitePaymentService.empty.error}")
    private Boolean webSitePaymentService;


    @NotNull(message="{webSitePaymentServiveContent.empty.error}")
    private WebSitePaymentServiveContent webSitePaymentServiveContent;
    @Getter
    @Setter
    @ToString

    private class WebSitePaymentServiveContent {
      private  Boolean openAPIDocument;
      private  Boolean ecommercePlatformPlugIns;
      private List<String> EcommercePlatformPlugInsList;
      private  String  ecommercePlatformPlugInsVersion;
      private  Boolean  alipay;
      private  Boolean  wechatPay;
    }
    @NotNull(message="{jsapiPaymentService.empty.error}")
    private Boolean jsapiPaymentService;
    private JSAPIPaymentServiceContent jsapiPaymentServiceContent;

    @Getter
    @Setter
    @ToString
    private class JSAPIPaymentServiceContent {

        private Boolean openJSAPIDocument;

        private Boolean wechatPay;

        private Boolean verifyOfficialAccountsPlatform;

        private String companyName;

        private String companyAddress;

        private String contactName;

        private String phone;

        private String appId;

        private String appSecret;
    }
    @NotNull(message="{weChatMallPaymentService.empty.error}")
    private Boolean weChatMallPaymentService;
}
