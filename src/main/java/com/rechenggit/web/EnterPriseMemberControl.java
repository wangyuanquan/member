package com.rechenggit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/enterpriseMember")
public class EnterPriseMemberControl extends BaseControl {
    private final static Logger logger = LoggerFactory.getLogger(EnterPriseMemberControl.class);

    @PostMapping("/saveServiceInfo")
    public static void saveEnterpriseServiceInfo() {
        System.out.println("ss");
    }
}
