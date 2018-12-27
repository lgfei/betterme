package com.lgfei.betterme.framework.core.service.impl;

import java.util.List;

import com.lgfei.betterme.framework.core.dao.IDao;
import com.lgfei.betterme.framework.core.service.IService;
import com.lgfei.betterme.framework.model.Query;
import com.lgfei.betterme.framework.model.vo.PageVO;

public abstract class BaseService<T, K> implements IService<T, K>
{
    protected abstract IDao<T, K> getDao();
    
    @Override
    public Integer selectCount(Query query)
    {
        return getDao().selectCount(query.asMap());
    }
    
    @Override
    public List<T> selectByPage(Query query, PageVO page)
    {
        return getDao().selectByPage(query.asMap(), page);
    }
    
    @Override
    public T selectById(K id)
    {
        return getDao().selectById(id);
    }
    
}
