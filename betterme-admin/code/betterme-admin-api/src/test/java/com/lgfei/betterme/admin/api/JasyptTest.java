package com.lgfei.betterme.admin.api;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApiApplication.class)
public class JasyptTest
{
    //注入StringEncryptor
    @Autowired
    StringEncryptor encryptor;
    
    @Test
    public void encry()
    {
        //加密root
        String username = encryptor.encrypt("root");
        System.out.println(username);
        //加密123
        String password = encryptor.encrypt("Admin.123");
        System.out.println(password);
    }
}
