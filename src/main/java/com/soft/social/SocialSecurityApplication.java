package com.soft.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.soft.social.*.dao")
public class SocialSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialSecurityApplication.class, args);
    }

}

