package com.lgfei.betterme.framework.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lgfei.betterme.framework.model.vo.PageVO;

@Mapper
public interface IDao<T, K>
{
    Integer selectCount(@Param("params") Map<String, Object> params);
    
    List<T> selectByPage(@Param("params") Map<String, Object> params, @Param("page") PageVO page);
    
    T selectById(K id);
}
