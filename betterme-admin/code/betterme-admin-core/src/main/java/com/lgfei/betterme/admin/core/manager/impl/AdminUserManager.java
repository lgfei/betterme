package com.lgfei.betterme.admin.core.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.core.manager.IAdminUserManager;
import com.lgfei.betterme.admin.core.service.IAdminUserService;
import com.lgfei.betterme.admin.model.dto.AdminUser;
import com.lgfei.betterme.framework.core.manager.impl.BaseManager;
import com.lgfei.betterme.framework.core.service.IBaseService;

@Service
public class AdminUserManager extends BaseManager<AdminUser> implements IAdminUserManager
{
    @Autowired
    private IAdminUserService service;
    
    @Override
    protected IBaseService<AdminUser> getService()
    {
        return service;
    }
    
}
