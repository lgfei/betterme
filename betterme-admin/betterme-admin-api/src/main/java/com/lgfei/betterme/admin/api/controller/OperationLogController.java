package com.lgfei.betterme.admin.api.controller;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgfei.betterme.admin.common.entity.OperationLog;
import com.lgfei.betterme.admin.core.service.IOperationLogService;
import com.lgfei.betterme.framework.api.controller.BaseController;

import io.swagger.annotations.Api;
 
/**
 * <p>
 * 操作日志表 前端控制器
 * </p>
 *
 * @author lgfei
 * @since 2019-07-18
 */
@Api(tags = {"操作日志表"})
@RestController
@RequestMapping("/operation-log")
public class  OperationLogController extends BaseController<IOperationLogService,OperationLog, Long> {
    
    @Override
    protected OperationLog newEntity() {
        return new OperationLog();
	}
}