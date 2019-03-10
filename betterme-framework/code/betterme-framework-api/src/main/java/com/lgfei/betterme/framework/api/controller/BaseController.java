package com.lgfei.betterme.framework.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;

import io.swagger.annotations.ApiOperation;

public abstract class BaseController<T>
{
    protected abstract IBaseManager<T> getManager();
    
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
    
    @ApiOperation("分页查询")
    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public PageResultVO<T> selectByPage(PageVO page,
        @RequestParam(value = "ew", required = false) QueryWrapper<T> queryWrapper)
    {
        return getManager().selectPage(page, queryWrapper);
    }
}
