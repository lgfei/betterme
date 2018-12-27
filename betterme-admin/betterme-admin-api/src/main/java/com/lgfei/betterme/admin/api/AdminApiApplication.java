package com.lgfei.betterme.admin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lgfei.betterme.framework.api.ApiApplication;

@SpringBootApplication
@ComponentScan("com.lgfei.betterme.admin.api")
public class AdminApiApplication extends ApiApplication
{
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(AdminApiApplication.class);
        app.run(args);
    }
}
