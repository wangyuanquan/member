package com.rechenggit.web;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class BaseControl {
    @Autowired
    protected HttpServletRequest request;

    @InitBinder
    protected void initBinder(HttpServletRequest  request) {
        String lang = request.getHeader("lang");
        if (StringUtils.isBlank(lang)) {
            lang = "en_US";

        }
        LocaleContextHolder.setLocale(new Locale(lang.split("_")[0], lang.split("_")[1]));
    }
}
