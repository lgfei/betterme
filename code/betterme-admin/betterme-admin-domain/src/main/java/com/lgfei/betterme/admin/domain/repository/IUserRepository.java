package com.lgfei.betterme.admin.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.lgfei.betterme.admin.model.dto.UserDto;
import com.lgfei.betterme.framework.core.repository.IRepository;

@Mapper
public interface IUserRepository extends IRepository<UserDto, String>
{
    
}
