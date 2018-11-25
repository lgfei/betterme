package com.lgfei.betterself.framework.core.manager.impl;

import java.util.List;

import com.lgfei.betterself.framework.core.manager.IManager;
import com.lgfei.betterself.framework.core.service.IService;
import com.lgfei.betterself.framework.model.Numbers;
import com.lgfei.betterself.framework.model.Query;
import com.lgfei.betterself.framework.model.vo.PageResultVO;
import com.lgfei.betterself.framework.model.vo.PageVO;
import com.lgfei.betterself.framework.model.vo.ResultVO;

public abstract class BaseManager<T, K> implements IManager<T, K>
{
    protected abstract IService<T, K> getService();
    
    @Override
    public PageResultVO<T> selectByPage(Query query, PageVO page)
    {
        Integer total = getService().selectCount(query);
        if (total == null || total.equals(Numbers.ZERO))
        {
            return new PageResultVO<T>();
        }
        List<T> rows = getService().selectByPage(query, page);
        
        PageResultVO<T> result = new PageResultVO<T>();
        result.setRows(rows);
        result.setTotal(total);
        
        return result;
    }
    
    @Override
    public ResultVO<T> selectById(K id)
    {
        T data = getService().selectById(id);
        ResultVO<T> result = new ResultVO<T>();
        result.setData(data);
        
        return result;
    }
    
}
