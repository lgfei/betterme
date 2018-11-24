package com.lgfei.betterself.framework.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lgfei.betterself.framework.api")
public class ApiApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication app = new SpringApplication(ApiApplication.class);
    	app.run(args);
    }
}
