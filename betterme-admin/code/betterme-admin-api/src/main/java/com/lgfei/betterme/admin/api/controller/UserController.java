package com.lgfei.betterme.admin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgfei.betterme.admin.core.manager.IUserManager;
import com.lgfei.betterme.admin.model.entity.User;
import com.lgfei.betterme.framework.api.controller.BaseController;

import io.swagger.annotations.Api;

@Api(description = "用户信息")
@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController<IUserManager, User, Long>
{
    
}
