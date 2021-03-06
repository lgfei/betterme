package com.lgfei.betterme.admin.api.controller;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import com.lgfei.betterme.admin.common.entity.LogOperate;
import com.lgfei.betterme.admin.core.service.ILogOperateService;

import com.lgfei.betterme.framework.api.controller.BaseController;
 
/**
 * <p>
 * 操作日志表 前端控制器
 * </p>
 *
 * @author lgfei
 * @since 2019-09-01
 */
@Api(tags = {"操作日志表"})
@RestController
@RequestMapping("/log-operate")
public class  LogOperateController extends BaseController<ILogOperateService, LogOperate, Long> {
    
    @Override
    protected LogOperate newEntity() {
        return new LogOperate();
	}
}