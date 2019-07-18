package com.lgfei.betterme.framework.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@SpringBootApplication
@ComponentScan("com.lgfei.betterme.framework.api")
@ConfigurationProperties
public class ApiApplication {
    @Bean
    @ConfigurationProperties(prefix = "spring.thymeleaf.variables")
    protected Properties getThymeleafVariables() {
        return new Properties();
    }

    @Resource
    protected void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
        if (viewResolver != null) {
            Map<String, Object> vars = new HashMap<>();
            Properties properties = getThymeleafVariables();
            Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
            for (Map.Entry<Object, Object> entry : entrySet) {
                vars.put(String.valueOf(entry.getKey()), entry.getValue());
            }
            viewResolver.setStaticVariables(vars);
        }
    }
}
