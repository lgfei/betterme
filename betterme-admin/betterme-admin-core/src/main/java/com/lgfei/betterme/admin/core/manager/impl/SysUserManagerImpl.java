package com.lgfei.betterme.admin.core.manager.impl;

import com.lgfei.betterme.admin.model.entity.SysUser;
import com.lgfei.betterme.admin.core.service.ISysUserService;
import com.lgfei.betterme.admin.core.manager.ISysUserManager;
import com.lgfei.betterme.framework.core.manager.impl.BaseManagerImpl;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现封装类
 * </p>
 *
 * @author lgfei
 * @since 2019-06-25
 */
@Service
public class SysUserManagerImpl 
	extends BaseManagerImpl<ISysUserService, SysUser, Long> 
	implements ISysUserManager 
{
    @Override
    protected SysUser newEntity()
    {
        return new SysUser();
    }
}

