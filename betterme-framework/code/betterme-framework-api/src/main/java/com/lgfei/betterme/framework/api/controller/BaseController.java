package com.lgfei.betterme.framework.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.lgfei.betterme.framework.api.IBaseController;
import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.model.BaseModel;
import com.lgfei.betterme.framework.model.constants.INumbers;
import com.lgfei.betterme.framework.model.vo.BatchDatasVO;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;
import com.lgfei.betterme.framework.model.vo.ResultVO;

public abstract class BaseController<MG extends IBaseManager<T, K>, T extends BaseModel<K>, K>
    implements IBaseController<T, K>
{
    @Autowired
    protected MG manager;
    
    @Override
    public IBaseManager<T, K> getManager()
    {
        return manager;
    }
    
    @Override
    public boolean preHandle(T entity, String params)
    {
        return true;
    }
    
    @Override
    public Integer selectCount(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().selectCount(entity, params);
        }
        return INumbers.ZERO;
    }
    
    @Override
    public PageResultVO<T> selectPage(T entity, PageVO page, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().selectPage(entity, page, params);
        }
        return new PageResultVO<>();
    }
    
    @Override
    public List<T> select(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().select(entity, params);
        }
        return new ArrayList<>();
    }
    
    @Override
    public T selectOne(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().selectOne(entity, params);
        }
        return null;
    }
    
    @Override
    public ResultVO<T> save(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().save(entity, params);
        }
        return new ResultVO.Builder<T>().err();
    }
    
    @Override
    public ResultVO<T> saveOrUpdate(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().saveOrUpdate(entity, params);
        }
        return new ResultVO.Builder<T>().err();
    }
    
    @Override
    public ResultVO<T> update(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().update(entity, params);
        }
        return new ResultVO.Builder<T>().err();
    }
    
    @Override
    public ResultVO<T> remove(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().remove(entity, params);
        }
        return new ResultVO.Builder<T>().err();
    }
    
    @Override
    public ResultVO<T> batchSave(@RequestBody BatchDatasVO<T> datas, String params)
    {
        return getManager().batchSave(datas, params);
    }
    
    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTemplate()
    {
        RequestMapping requestMapping = this.getClass().getAnnotation(RequestMapping.class);
        if (null == requestMapping)
        {
            return "index";
        }
        String[] values = requestMapping.value();
        if (null == values || values.length == MyNumbers.ZERO)
        {
            return "index";
        }
        String module = values[0];
        if (null == module || module.length() == MyNumbers.ZERO)
        {
            return "index";
        }
        if (module.startsWith("/"))
        {
            module = module.substring(MyNumbers.ONE);
        }
        return new StringBuilder(module).append("/index").toString();
    }*/
}
