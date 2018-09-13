package com.rechenggit.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Getter
@Setter
public class WebSitePaymentServiveContent {
    private  Boolean openAPIDocument;
    private  Boolean ecommercePlatformPlugIns;
    private List<String> EcommercePlatformPlugInsList;
    private  String  ecommercePlatformPlugInsVersion;
    private  Boolean  websiteAlipay;
    private  Boolean  websiteWechatPay;
}
