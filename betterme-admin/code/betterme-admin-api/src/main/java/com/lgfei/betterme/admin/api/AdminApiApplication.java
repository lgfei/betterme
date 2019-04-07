package com.lgfei.betterme.admin.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lgfei.betterme.framework.api.ApiApplication;

/**
 * <p>
 * api启动类
 * </p>
 *
 * @author lgfei
 * @since 2019-04-07
 */
@SpringBootApplication
@ComponentScan("com.lgfei.betterme.admin")
@MapperScan("com.lgfei.betterme.admin.core.mapper")
public class AdminApiApplication extends ApiApplication
{
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(AdminApiApplication.class);
        app.run(args);
        System.err.println("http://localhost:8080/swagger-ui.html");
    }
}
