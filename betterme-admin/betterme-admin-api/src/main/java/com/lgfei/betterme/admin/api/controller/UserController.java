package com.lgfei.betterme.admin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgfei.betterme.admin.core.manager.IUserManager;
import com.lgfei.betterme.admin.model.entity.User;
import com.lgfei.betterme.framework.api.controller.BaseController;

import io.swagger.annotations.Api;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author lgfei
 * @since 2019-04-07
 */
@Api(tags = {"用户信息表"})
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<IUserManager, User, Long>
{
    
}