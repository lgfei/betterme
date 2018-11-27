package com.lgfei.betterself.admin.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgfei.betterself.admin.domain.repository.IUserRepository;
import com.lgfei.betterself.admin.domain.service.IUserService;
import com.lgfei.betterself.admin.model.dto.UserDto;
import com.lgfei.betterself.framework.core.repository.IRepository;
import com.lgfei.betterself.framework.core.service.impl.BaseService;

@Service
public class UserService extends BaseService<UserDto, String> implements IUserService
{
    @Autowired
    private IUserRepository repository;
    
    @Override
    protected IRepository<UserDto, String> getRepository()
    {
        return repository;
    }
}
