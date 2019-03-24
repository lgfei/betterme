package com.lgfei.betterme.admin.core.service.impl;

import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.core.mapper.IUserMapper;
import com.lgfei.betterme.admin.core.service.IUserService;
import com.lgfei.betterme.admin.model.entity.User;
import com.lgfei.betterme.framework.core.service.impl.BaseService;

@Service
public class UserService extends BaseService<IUserMapper, User, Long> implements IUserService
{
    
}
