package com.lgfei.betterme.framework.model.entity;

import java.io.Serializable;

public class BaseModel<K> implements Serializable
{
    private static final long serialVersionUID = -8312345133182172608L;
    
    private K id;
    
    private Integer status;
    
    private String createUser;
    
    private String createTime;
    
    private String updateUser;
    
    private String updateTime;
    
    private String remark;
    
    public K getId()
    {
        return id;
    }
    
    public void setId(K id)
    {
        this.id = id;
    }
    
    public Integer getStatus()
    {
        return status;
    }
    
    public void setStatus(Integer status)
    {
        this.status = status;
    }
    
    public String getCreateUser()
    {
        return createUser;
    }
    
    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public String getUpdateUser()
    {
        return updateUser;
    }
    
    public void setUpdateUser(String updateUser)
    {
        this.updateUser = updateUser;
    }
    
    public String getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }
    
    public String getRemark()
    {
        return remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
}
