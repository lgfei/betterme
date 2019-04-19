package com.lgfei.betterme.framework.model.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity<K> implements Serializable
{
    private static final long serialVersionUID = -8312345133182172608L;
    
    private K id;
    
    private Integer status;
    
    private String createUser;
    
    private Date createTime;
    
    private String updateUser;
    
    private Date updateTime;
    
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
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
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
    
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
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
