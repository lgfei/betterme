package com.lgfei.betterme.admin.core.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgfei.betterme.admin.model.dto.AdminUser;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;

@Mapper
public interface IAdminUserMapper extends IBaseMapper<AdminUser>
{
    
}
