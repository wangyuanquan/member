package com.anole;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = { "com.anole.core.dal.mapper" })
//@EnableCaching
public class MemberManageServiceApplication{

    public   static void main(String[] args) {
        SpringApplication.run(MemberManageServiceApplication.class, args);
    }

}
