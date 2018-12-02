package com.lgfei.betterme.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgfei.betterme.framework.core.manager.IManager;
import com.lgfei.betterme.framework.web.controller.BaseController;

@Controller
@RequestMapping("")
public class PortalController extends BaseController<Object, String>
{
    
    @Override
    protected IManager<Object, String> getManager()
    {
        return null;
    }
    
}
