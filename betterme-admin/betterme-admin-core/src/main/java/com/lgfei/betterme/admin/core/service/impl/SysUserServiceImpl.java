package com.lgfei.betterme.admin.core.service.impl;

import com.lgfei.betterme.admin.common.entity.SysUser;
import com.lgfei.betterme.admin.core.mapper.SysUserMapper;
import com.lgfei.betterme.admin.core.service.ISysUserService;
import com.lgfei.betterme.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author lgfei
 * @since 2019-07-29
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser, Long> 
    implements ISysUserService {

}
