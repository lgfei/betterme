package com.lgfei.betterme.admin.core.manager.impl;

import com.lgfei.betterme.admin.model.entity.User;
import com.lgfei.betterme.admin.core.service.IUserService;
import com.lgfei.betterme.admin.core.manager.IUserManager;
import com.lgfei.betterme.framework.core.manager.impl.BaseManagerImpl;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现封装类
 * </p>
 *
 * @author lgfei
 * @since 2019-04-07
 */
@Service
public class UserManagerImpl 
	extends BaseManagerImpl<IUserService, User, Long> 
	implements IUserManager 
{
    @Override
    protected User newEntity()
    {
        return new User();
    }
}

