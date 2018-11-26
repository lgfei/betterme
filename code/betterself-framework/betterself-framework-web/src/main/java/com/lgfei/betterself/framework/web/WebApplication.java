package com.lgfei.betterself.framework.web;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lgfei.betterself.framework.util.DesUtil;

@SpringBootApplication
@ComponentScan("com.lgfei.betterself.framework.web")
@ConfigurationProperties
public class WebApplication
{
    private static final Logger LOG = LoggerFactory.getLogger(WebApplication.class);
    
    @Value("${encrypt.key}")
    private String decryptKey;
    
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public Properties getDbProperies()
    {
        return new Properties();
    }
    
    /** 
     * DataSource配置
     * @return DataSource
     * @see [类、类#方法、类#成员]
     */
    @Bean
    public DataSource dataSource()
    {
        Properties dbPros = getDbProperies();
        try
        {
            // 解密
            dbPros.setProperty("password", DesUtil.decrypt(dbPros.getProperty("password"), decryptKey));
        }
        catch (Exception e)
        {
            LOG.error("解密数据库密码失败:{}", e.getMessage());
        }
        PoolProperties pool = JSON.parseObject(JSONObject.toJSONString(dbPros), PoolProperties.class);
        pool.setDbProperties(dbPros);
        return new org.apache.tomcat.jdbc.pool.DataSource(pool);
        
    }
}
