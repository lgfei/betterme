package com.lgfei.betterme.framework.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lgfei.betterme.framework.core.manager.IManager;
import com.lgfei.betterme.framework.model.MyNumbers;
import com.lgfei.betterme.framework.model.Query;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;

public abstract class BaseController<T, K>
{
    protected abstract IManager<T, K> getManager();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
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
    }
    
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageResultVO<T> selectByPage(Query query, PageVO page)
    {
        return getManager().selectByPage(query, page);
    }
}
