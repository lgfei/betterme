package com.lgfei.betterme.admin.core.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.core.manager.IUserManager;
import com.lgfei.betterme.admin.core.mapper.IUserMapper;
import com.lgfei.betterme.admin.core.service.IUserService;
import com.lgfei.betterme.admin.model.User;
import com.lgfei.betterme.framework.core.manager.impl.BaseManager;
import com.lgfei.betterme.framework.core.service.IBaseService;

@Service
public class UserManager extends BaseManager<IUserMapper, User, Long> implements IUserManager
{
    @Autowired
    private IUserService service;
    
    @Override
    protected IBaseService<IUserMapper, User, Long> getService()
    {
        return service;
    }
    
    @Override
    protected User newEntity()
    {
        return new User();
    }
    
}
