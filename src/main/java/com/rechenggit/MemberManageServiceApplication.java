package com.rechenggit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = { "com.rechenggit.core.dal.mapper" })
//@EnableCaching
public class MemberManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberManageServiceApplication.class, args);
    }
}
