package com.lgfei.betterself.admin.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lgfei.betterself.framework.web.WebApplication;

@SpringBootApplication
@ComponentScan("com.lgfei.betterself.admin")
@MapperScan("com.lgfei.betterself.admin.domain.repository")
public class AdminWeApplication extends WebApplication
{
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(AdminWeApplication.class);
        app.run(args);
    }
}
