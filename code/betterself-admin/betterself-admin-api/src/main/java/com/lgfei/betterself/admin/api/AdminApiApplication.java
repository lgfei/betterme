package com.lgfei.betterself.admin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lgfei.betterself.framework.api.ApiApplication;

@SpringBootApplication
@ComponentScan("com.lgfei.betterself.admin.api")
public class AdminApiApplication extends ApiApplication
{
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(AdminApiApplication.class);
        app.run(args);
    }
}
