package com.lgfei.betterme.admin.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgfei.betterme.admin.core.manager.IAdminUserManager;
import com.lgfei.betterme.admin.model.dto.AdminUser;
import com.lgfei.betterme.framework.api.controller.BaseController;
import com.lgfei.betterme.framework.core.manager.IBaseManager;

import io.swagger.annotations.Api;

@Api("用户信息")
@Controller
@RequestMapping("/admin/user")
public class AdminUserController extends BaseController<AdminUser>
{
    @Autowired
    private IAdminUserManager manager;
    
    @Override
    protected IBaseManager<AdminUser> getManager()
    {
        return manager;
    }
    
}
