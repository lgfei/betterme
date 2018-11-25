package com.lgfei.betterself.framework.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lgfei.betterself.framework.core.manager.IManager;
import com.lgfei.betterself.framework.model.Query;
import com.lgfei.betterself.framework.model.vo.PageResultVO;
import com.lgfei.betterself.framework.model.vo.PageVO;

public abstract class BaseController<T, K>
{
    protected abstract IManager<T, K> getManager();
    
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageResultVO<T> selectByPage(Query query, PageVO page)
    {
        return getManager().selectByPage(query, page);
    }
}
