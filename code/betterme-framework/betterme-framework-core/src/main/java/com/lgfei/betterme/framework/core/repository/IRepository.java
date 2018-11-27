package com.lgfei.betterself.framework.core.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lgfei.betterself.framework.model.vo.PageVO;

@Mapper
public interface IRepository<T,K>
{
    Integer selectCont(@Param("params")Map<String, Object> params);
    
    List<T> selectByPage(@Param("params")Map<String, Object> params,@Param("page")PageVO page);

    T selectById(K id);
}
