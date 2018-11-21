package com.anole.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * webservice 代理工厂
 */
@Component
public class WsClient {
    private static final Logger _log = LoggerFactory.getLogger(WsClient.class);

    private final static JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();

    public Object getWsClient(String address, Class<?> serviceClass) {
        _log.debug("WsClient address:" + address+" class:"+serviceClass);
        jaxWsProxyFactoryBean.setAddress(address);
        jaxWsProxyFactoryBean.setServiceClass(serviceClass);
        Object object = jaxWsProxyFactoryBean.create();
        return object;
    }
}
