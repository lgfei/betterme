package com.lgfei.betterself.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lgfei.betterself.admin.domain.manager.IUserManager;
import com.lgfei.betterself.admin.model.dto.UserDto;
import com.lgfei.betterself.framework.core.manager.IManager;
import com.lgfei.betterself.framework.web.controller.BaseController;

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
