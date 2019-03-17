package com.lgfei.betterme.admin.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgfei.betterme.admin.core.manager.IUserManager;
import com.lgfei.betterme.admin.model.User;
import com.lgfei.betterme.framework.core.controller.BaseController;
import com.lgfei.betterme.framework.core.manager.IBaseManager;

import io.swagger.annotations.Api;

@Api(description = "用户信息")
@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController<User>
{
    @Autowired
    private IUserManager manager;
    
    @Override
    protected IBaseManager<User> getManager()
    {
        return manager;
    }
    
}
