package com.lgfei.betterme.admin.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.domain.repository.IUserRepository;
import com.lgfei.betterme.admin.domain.service.IUserService;
import com.lgfei.betterme.admin.model.dto.UserDto;
import com.lgfei.betterme.framework.core.repository.IRepository;
import com.lgfei.betterme.framework.core.service.impl.BaseService;

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
