package com.lgfei.betterme.framework.core.manager;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;
import com.lgfei.betterme.framework.model.vo.ResultVO;

public interface IBaseManager<T>
{
    Integer selectCount(QueryWrapper<T> queryWrapper);
    
    PageResultVO<T> selectPage(PageVO pageVO, QueryWrapper<T> queryWrapper);
    
    List<T> select(QueryWrapper<T> queryWrapper);
    
    T selectOne(QueryWrapper<T> queryWrapper);
    
    ResultVO<T> save(T entity);
    
    boolean update(UpdateWrapper<T> updateWrapper);
    
    boolean remove(QueryWrapper<T> queryWrapper);
}
