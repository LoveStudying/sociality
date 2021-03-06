package com.zyl.sociality;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.zyl.sociality.mapper")
@ServletComponentScan
public class SocialityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialityApplication.class, args);
    }
}
