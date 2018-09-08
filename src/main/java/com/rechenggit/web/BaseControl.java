package com.rechenggit.web;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseControl {
    @Autowired
    protected HttpServletRequest request;
}
