package com.rechenggit.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JSAPIPaymentServiceContent {

    private Boolean openJSAPIDocument;

    private Boolean jsapWechatPay;

    private Boolean verifyOfficialAccountsPlatform;

    private String jsapiCompanyName;

    private String jsapiCompanyAddress;

    private String jsapiContactName;

    private String phone;

    private String appId;

    private String appSecret;
}