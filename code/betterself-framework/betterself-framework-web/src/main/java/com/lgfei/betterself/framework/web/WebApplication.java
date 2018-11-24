package com.lgfei.betterself.framework.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lgfei.betterself.framework.web")
public class WebApplication
{
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(WebApplication.class);
        app.run(args);
    }
}
