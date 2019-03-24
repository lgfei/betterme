package com.lgfei.betterme.admin.core.manager.impl;

import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.core.manager.IUserManager;
import com.lgfei.betterme.admin.core.service.IUserService;
import com.lgfei.betterme.admin.model.entity.User;
import com.lgfei.betterme.framework.core.manager.impl.BaseManager;

@Service
public class UserManager extends BaseManager<IUserService, User, Long> implements IUserManager
{
    @Override
    protected User newEntity()
    {
        return new User();
    }
    
}
