package com.rechenggit.web;

import com.rechenggit.core.common.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/member")
public class LoginControl extends BaseControl {
    private final static Logger logger = LoggerFactory.getLogger(LoginControl.class);

    @PostMapping("/login")
    public BaseResponse login(){

        return success();
    }

}
