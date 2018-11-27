package com.lgfei.betterme.admin.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lgfei.betterme.framework.web.WebApplication;

@SpringBootApplication
@ComponentScan("com.lgfei.betterme.admin")
@MapperScan("com.lgfei.betterme.admin.domain.repository")
public class AdminWeApplication extends WebApplication
{
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(AdminWeApplication.class);
        app.run(args);
    }
}
