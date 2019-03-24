package com.lgfei.betterme.admin.model.entity;

import com.lgfei.betterme.framework.model.entity.BaseEntity;

public class User extends BaseEntity<Long>
{
    private static final long serialVersionUID = 7236620202550839441L;
    
    private String userNo;
    
    private String account;
    
    private String name;
    
    private String password;
    
    private String gender;
    
    private String tell;
    
    private String email;
    
    public String getUserNo()
    {
        return userNo;
    }
    
    public void setUserNo(String userNo)
    {
        this.userNo = userNo;
    }
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public String getTell()
    {
        return tell;
    }
    
    public void setTell(String tell)
    {
        this.tell = tell;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
}
