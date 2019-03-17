package com.lgfei.betterme.framework.core.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;
import com.lgfei.betterme.framework.model.vo.ResultVO;

import io.swagger.annotations.ApiOperation;

public abstract class BaseController<T>
{
    protected abstract IBaseManager<T> getManager();
    
    @ApiOperation("求总数")
    @ResponseBody
    @RequestMapping(value = "/count", method = {RequestMethod.POST, RequestMethod.GET})
    public Integer selectCount(QueryWrapper<T> queryWrapper)
    {
        return getManager().selectCount(queryWrapper);
    }
    
    @ApiOperation("分页查询")
    @ResponseBody
    @RequestMapping(value = "/page", method = {RequestMethod.POST, RequestMethod.GET})
    public PageResultVO<T> selectPage(PageVO page, QueryWrapper<T> queryWrapper)
    {
        return getManager().selectPage(page, queryWrapper);
    }
    
    @ApiOperation("普通查询")
    @ResponseBody
    @RequestMapping(value = "/select", method = {RequestMethod.POST, RequestMethod.GET})
    public List<T> select(QueryWrapper<T> queryWrapper)
    {
        return getManager().select(queryWrapper);
    }
    
    @ApiOperation("单个查询")
    @ResponseBody
    @RequestMapping(value = "/one", method = {RequestMethod.POST, RequestMethod.GET})
    public T selectOne(QueryWrapper<T> queryWrapper)
    {
        return getManager().selectOne(queryWrapper);
    }
    
    @ApiOperation("单个保存")
    @ResponseBody
    @RequestMapping(value = "/save", method = {RequestMethod.PUT})
    public ResultVO<T> selectOne(T entity)
    {
        return getManager().save(entity);
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
