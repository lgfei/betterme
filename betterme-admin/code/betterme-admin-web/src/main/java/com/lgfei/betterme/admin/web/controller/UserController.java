package com.lgfei.betterme.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgfei.betterme.admin.domain.manager.IUserManager;
import com.lgfei.betterme.admin.model.dto.UserDto;
import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.web.controller.BaseController;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<UserDto>
{
    @Autowired
    private IUserManager manager;
    
    @Override
    protected IBaseManager<UserDto> getManager()
    {
        return manager;
    }
    
}
