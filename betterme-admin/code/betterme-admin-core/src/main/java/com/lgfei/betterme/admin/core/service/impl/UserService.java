package com.lgfei.betterme.admin.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.core.mapper.IUserMapper;
import com.lgfei.betterme.admin.core.service.IUserService;
import com.lgfei.betterme.admin.model.User;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;
import com.lgfei.betterme.framework.core.service.impl.BaseService;

@Service
public class UserService extends BaseService<IUserMapper, User> implements IUserService
{
    @Autowired
    private IUserMapper mapper;
    
    @Override
    protected IBaseMapper<User> getMapper()
    {
        return mapper;
    }
}
