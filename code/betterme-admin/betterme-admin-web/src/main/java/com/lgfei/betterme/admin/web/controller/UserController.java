package com.lgfei.betterme.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lgfei.betterme.admin.domain.manager.IUserManager;
import com.lgfei.betterme.admin.model.dto.UserDto;
import com.lgfei.betterme.framework.core.manager.IManager;
import com.lgfei.betterme.framework.web.controller.BaseController;

@Controller("/user")
public class UserController extends BaseController<UserDto, String>
{
    @Autowired
    private IUserManager manager;
    
    @Override
    protected IManager<UserDto, String> getManager()
    {
        return manager;
    }
    
}
