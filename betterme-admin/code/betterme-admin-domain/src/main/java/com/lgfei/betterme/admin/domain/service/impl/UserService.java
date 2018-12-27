package com.lgfei.betterme.admin.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.domain.dao.IUserDao;
import com.lgfei.betterme.admin.domain.service.IUserService;
import com.lgfei.betterme.admin.model.dto.UserDto;
import com.lgfei.betterme.framework.core.dao.IDao;
import com.lgfei.betterme.framework.core.service.impl.BaseService;

@Service
public class UserService extends BaseService<UserDto, String> implements IUserService
{
    @Autowired
    private IUserDao dao;
    
    @Override
    protected IDao<UserDto, String> getDao()
    {
        return dao;
    }
}
