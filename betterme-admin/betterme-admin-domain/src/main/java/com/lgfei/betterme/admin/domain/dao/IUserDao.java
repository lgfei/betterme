package com.lgfei.betterme.admin.domain.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lgfei.betterme.admin.model.dto.UserDto;
import com.lgfei.betterme.framework.core.dao.IDao;

@Mapper
public interface IUserDao extends IDao<UserDto, String>
{
    
}
