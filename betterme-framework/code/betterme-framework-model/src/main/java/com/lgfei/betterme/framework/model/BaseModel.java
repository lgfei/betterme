package com.lgfei.betterme.framework.model;

public class BaseModel<K> implements IModel<K>
{
    private static final long serialVersionUID = -8312345133182172608L;
    
    private K id;
    
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
