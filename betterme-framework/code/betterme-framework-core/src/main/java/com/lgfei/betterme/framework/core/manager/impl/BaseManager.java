package com.lgfei.betterme.framework.core.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.core.service.IBaseService;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;

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
    
}
