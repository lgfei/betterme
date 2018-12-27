package com.lgfei.betterme.admin.domain.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.domain.manager.IUserManager;
import com.lgfei.betterme.admin.domain.service.IUserService;
import com.lgfei.betterme.admin.model.dto.UserDto;
import com.lgfei.betterme.framework.core.manager.impl.BaseManager;
import com.lgfei.betterme.framework.core.service.IService;

@Service
public class UserManager extends BaseManager<UserDto, String> implements IUserManager
{
    @Autowired
    private IUserService service;
    
    @Override
    protected IService<UserDto, String> getService()
    {
        return service;
    }
    
}
