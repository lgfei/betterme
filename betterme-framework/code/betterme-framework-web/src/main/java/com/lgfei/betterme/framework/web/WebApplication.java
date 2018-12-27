package com.lgfei.betterme.framework.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lgfei.betterme.framework.util.DesUtil;

@SpringBootApplication
@ComponentScan("com.lgfei.betterme.framework.web")
@ConfigurationProperties
public class WebApplication
{
    private static final Logger LOG = LoggerFactory.getLogger(WebApplication.class);
    
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    protected Properties getDbProperies()
    {
        return new Properties();
    }
    
    /** 
     * DataSource配置
     * @return DataSource
     * @see [类、类#方法、类#成员]
     */
    @Bean
    protected DataSource dataSource()
    {
        Properties dbPros = getDbProperies();
        try
        {
            // 解密
            dbPros.setProperty("password",
                DesUtil.decrypt(dbPros.getProperty("password"), dbPros.getProperty("cryptKey")));
        }
        catch (Exception e)
        {
            LOG.error("解密数据库密码失败:{}", e.getMessage());
        }
        PoolProperties pool = JSON.parseObject(JSONObject.toJSONString(dbPros), PoolProperties.class);
        pool.setDbProperties(dbPros);
        
        return new org.apache.tomcat.jdbc.pool.DataSource(pool);
    }
    
    @Bean
    @ConfigurationProperties(prefix = "spring.thymeleaf.variables")
    protected Properties getThymeleafVariables()
    {
        return new Properties();
    }
    
    @Resource
    protected void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver)
    {
        if (viewResolver != null)
        {
            Map<String, Object> vars = new HashMap<>();
            Properties properties = getThymeleafVariables();
            Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
            for (Map.Entry<Object, Object> entry : entrySet)
            {
                vars.put(String.valueOf(entry.getKey()), entry.getValue());
            }
            viewResolver.setStaticVariables(vars);
        }
    }
}
