package com.lgfei.betterme.framework.core.mpper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface IBaseMapper<T, K> extends BaseMapper<T>
{
    
}
