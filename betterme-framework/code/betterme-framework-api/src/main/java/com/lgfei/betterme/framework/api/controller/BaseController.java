package com.lgfei.betterme.framework.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;
import com.lgfei.betterme.framework.model.BaseModel;
import com.lgfei.betterme.framework.model.constants.INumbers;
import com.lgfei.betterme.framework.model.vo.BatchDatasVO;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;
import com.lgfei.betterme.framework.model.vo.ResultVO;

import io.swagger.annotations.ApiOperation;

public abstract class BaseController<M extends IBaseMapper<T>, T extends BaseModel<K>, K>
{
    protected abstract IBaseManager<M, T, K> getManager();
    
    protected abstract boolean preHandle(T entity, String params);
    
    @ApiOperation("求总数")
    @ResponseBody
    @RequestMapping(value = "/count.json", method = {RequestMethod.POST, RequestMethod.GET})
    public Integer selectCount(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().selectCount(entity, params);
        }
        return INumbers.ZERO;
    }
    
    @ApiOperation("分页查询")
    @ResponseBody
    @RequestMapping(value = "/page.json", method = {RequestMethod.POST, RequestMethod.GET})
    public PageResultVO<T> selectPage(T entity, PageVO page, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().selectPage(entity, page, params);
        }
        return new PageResultVO<>();
    }
    
    @ApiOperation("普通查询")
    @ResponseBody
    @RequestMapping(value = "/select.json", method = {RequestMethod.POST, RequestMethod.GET})
    public List<T> select(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().select(entity, params);
        }
        return new ArrayList<>();
    }
    
    @ApiOperation("单个查询")
    @ResponseBody
    @RequestMapping(value = "/one.json", method = {RequestMethod.POST, RequestMethod.GET})
    public T selectOne(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().selectOne(entity, params);
        }
        return null;
    }
    
    @ApiOperation("单个保存")
    @ResponseBody
    @RequestMapping(value = "/save.json", method = {RequestMethod.POST})
    public ResultVO<T> save(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().save(entity, params);
        }
        return new ResultVO.Builder<T>().err();
    }
    
    @ApiOperation("单个保存或修改")
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdate.json", method = {RequestMethod.POST})
    public ResultVO<T> saveOrUpdate(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().saveOrUpdate(entity, params);
        }
        return new ResultVO.Builder<T>().err();
    }
    
    @ApiOperation("单个修改")
    @ResponseBody
    @RequestMapping(value = "/update.json", method = {RequestMethod.POST})
    public ResultVO<T> update(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().update(entity, params);
        }
        return new ResultVO.Builder<T>().err();
    }
    
    @ApiOperation("删除")
    @ResponseBody
    @RequestMapping(value = "/remove.json", method = {RequestMethod.POST})
    public ResultVO<T> remove(T entity, String params)
    {
        boolean flag = preHandle(entity, params);
        if (flag)
        {
            return getManager().remove(entity, params);
        }
        return new ResultVO.Builder<T>().err();
    }
    
    @ApiOperation("批量保存(增删改)")
    @ResponseBody
    @RequestMapping(value = "/batchSave.json", method = {RequestMethod.POST})
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
