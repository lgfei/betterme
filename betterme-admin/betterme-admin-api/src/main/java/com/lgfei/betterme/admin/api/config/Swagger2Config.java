package com.lgfei.betterme.admin.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * Swagger配置类
 * </p>
 *
 * @author lgfei
 * @since 2019-09-01
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.lgfei.betterme.admin.api"))
            .paths(PathSelectors.any())
            .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("betterme-admin APIs")
            .description("betterme-admin APIs")
            .termsOfServiceUrl("https://lgfei.github.io/")
            .contact(new Contact("lgfei", "https://lgfei.github.io/", "email@xxx.com"))
            .version("1.0.0")
            .build();
    }
    
}
