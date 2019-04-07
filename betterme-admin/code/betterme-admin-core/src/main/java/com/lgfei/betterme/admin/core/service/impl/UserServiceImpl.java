package com.lgfei.betterme.admin.core.service.impl;

import com.lgfei.betterme.admin.model.entity.User;
import com.lgfei.betterme.admin.core.mapper.UserMapper;
import com.lgfei.betterme.admin.core.service.IUserService;
import com.lgfei.betterme.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author lgfei
 * @since 2019-04-07
 */
@Service
public class UserServiceImpl 
    extends BaseServiceImpl<UserMapper, User, Long> 
    implements IUserService 
{

}
