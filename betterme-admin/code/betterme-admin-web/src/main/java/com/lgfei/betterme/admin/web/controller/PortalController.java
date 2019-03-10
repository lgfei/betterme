package com.lgfei.betterme.admin.web.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.web.controller.BaseController;

@Controller
@RequestMapping("")
public class PortalController extends BaseController<Serializable>
{
    
    @Override
    protected IBaseManager<Serializable> getManager()
    {
        return null;
    }
}
