package com.lgfei.betterself.admin.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.lgfei.betterself.admin.model.dto.UserDto;
import com.lgfei.betterself.framework.core.repository.IRepository;

@Mapper
public interface IUserRepository extends IRepository<UserDto, String>
{
    
}
