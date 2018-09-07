package com.rechenggit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/member")
public class MemberFacade {
    @GetMapping(value = "/query", produces = {"application/json;charset=UTF-8"})

    public String addUser(String memberId){

        return "1111";

    }



}
