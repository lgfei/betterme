package com.lgfei.betterme.admin.core.service.impl;

import org.springframework.stereotype.Service;

import com.lgfei.betterme.admin.core.mapper.UserMapper;
import com.lgfei.betterme.admin.core.service.IUserService;
import com.lgfei.betterme.admin.model.entity.User;
import com.lgfei.betterme.framework.core.service.impl.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User, Long> implements IUserService
{
    
}
