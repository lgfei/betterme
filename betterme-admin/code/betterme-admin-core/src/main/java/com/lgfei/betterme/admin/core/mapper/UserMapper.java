package com.lgfei.betterme.admin.core.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgfei.betterme.admin.model.entity.User;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;

@Mapper
public interface UserMapper extends IBaseMapper<User, Long>
{
    
}
