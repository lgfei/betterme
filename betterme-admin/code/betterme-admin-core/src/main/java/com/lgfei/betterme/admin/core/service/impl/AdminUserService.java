package com.lgfei.betterme.admin.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.core.mapper.IAdminUserMapper;
import com.lgfei.betterme.admin.core.service.IAdminUserService;
import com.lgfei.betterme.admin.model.dto.AdminUser;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;
import com.lgfei.betterme.framework.core.service.impl.BaseService;

@Service
public class AdminUserService extends BaseService<AdminUser> implements IAdminUserService
{
    @Autowired
    private IAdminUserMapper mapper;
    
    @Override
    protected IBaseMapper<AdminUser> getMapper()
    {
        return mapper;
    }
}
