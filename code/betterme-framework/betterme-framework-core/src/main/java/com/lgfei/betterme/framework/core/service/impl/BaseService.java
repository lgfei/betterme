package com.lgfei.betterme.framework.core.service.impl;

import java.util.List;

import com.lgfei.betterme.framework.core.repository.IRepository;
import com.lgfei.betterme.framework.core.service.IService;
import com.lgfei.betterme.framework.model.Query;
import com.lgfei.betterme.framework.model.vo.PageVO;

public abstract class BaseService<T, K> implements IService<T, K>
{
    protected abstract IRepository<T, K> getRepository();
    
    @Override
    public Integer selectCount(Query query)
    {
        return getRepository().selectCont(query.asMap());
    }
    
    @Override
    public List<T> selectByPage(Query query, PageVO page)
    {
        return getRepository().selectByPage(query.asMap(), page);
    }
    
    @Override
    public T selectById(K id)
    {
        return getRepository().selectById(id);
    }
    
}
