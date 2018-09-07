/*
package com.rechenggit.config;

import com.netfinworks.ma.service.facade.ILoginPwdFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WsConfig {

    @Value("${wsclient.ma_member_login}")
    private String ma_member_login;

    @Autowired
    private WsClient wsClient;

    @Bean
    public ILoginPwdFacade getILoginPwdFacade(){
        return (ILoginPwdFacade) wsClient.getWsClient(ma_member_login,ILoginPwdFacade.class);
    }

}
*/
