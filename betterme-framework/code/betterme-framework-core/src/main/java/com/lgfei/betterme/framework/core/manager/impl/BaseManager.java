package com.lgfei.betterme.framework.core.manager.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.core.service.IBaseService;
import com.lgfei.betterme.framework.model.enums.ResultCodeEnum;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;
import com.lgfei.betterme.framework.model.vo.ResultVO;

public abstract class BaseManager<T> implements IBaseManager<T>
{
    protected abstract IBaseService<T> getService();
    
    @Override
    public Integer selectCount(QueryWrapper<T> queryWrapper)
    {
        return getService().count(queryWrapper);
    }
    
    @Override
    public PageResultVO<T> selectPage(PageVO pageVo, QueryWrapper<T> queryWrapper)
    {
        Page<T> page = new Page<>();
        page.setSize(pageVo.getPageSize());
        page.setCurrent(pageVo.getPageNum());
        
        IPage<T> rs = getService().page(page, queryWrapper);
        if (null == rs)
        {
            return new PageResultVO<T>();
        }
        
        PageResultVO<T> pageResultVo = new PageResultVO<T>();
        pageResultVo.setTotal(rs.getTotal());
        pageResultVo.setRows(rs.getRecords());
        
        return pageResultVo;
    }
    
    @Override
    public List<T> select(QueryWrapper<T> queryWrapper)
    {
        return getService().list(queryWrapper);
    }
    
    @Override
    public T selectOne(QueryWrapper<T> queryWrapper)
    {
        return getService().getOne(queryWrapper);
    }
    
    @Override
    public ResultVO<T> save(T entity)
    {
        ResultVO<T> result = new ResultVO<>();
        if (null == entity)
        {
            result.setResultCode(ResultCodeEnum.INVALID_PARAM.getCode());
            result.setResultMsg(ResultCodeEnum.INVALID_PARAM.getMsg());
            return result;
        }
        
        boolean flag = getService().save(entity);
        if (flag)
        {
            result.setData(entity);
            return result;
        }
        result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
        result.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getMsg());
        return result;
    }
    
    @Override
    public boolean update(UpdateWrapper<T> updateWrapper)
    {
        return getService().update(updateWrapper);
    }
    
    @Override
    public boolean remove(QueryWrapper<T> queryWrapper)
    {
        return getService().remove(queryWrapper);
    }
    
}
