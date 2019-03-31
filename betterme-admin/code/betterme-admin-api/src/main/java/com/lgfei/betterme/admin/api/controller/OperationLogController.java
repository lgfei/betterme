package com.lgfei.betterme.admin.api.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

import com.lgfei.betterme.admin.model.entity.OperationLog;
import com.lgfei.betterme.admin.core.manager.IOperationLogManager;

import com.lgfei.betterme.framework.api.controller.BaseController;
 
/**
 * <p>
    * 操作日志表 前端控制器
    * </p>
 *
 * @author lgfei
 * @since 2019-03-31
 */
@Api(tags = {"操作日志表"})
@Controller
@RequestMapping("/admin/operation-log")
public class  OperationLogController 
	extends BaseController<IOperationLogManager,OperationLog, Long> 
{

}