package com.lgfei.betterme.admin.core.manager.impl;

import com.lgfei.betterme.admin.model.entity.OperationLog;
import com.lgfei.betterme.admin.core.service.IOperationLogService;
import com.lgfei.betterme.admin.core.manager.IOperationLogManager;
import com.lgfei.betterme.framework.core.manager.impl.BaseManagerImpl;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现封装类
 * </p>
 *
 * @author lgfei
 * @since 2019-03-31
 */
@Service
public class OperationLogManagerImpl 
	extends BaseManagerImpl<IOperationLogService, OperationLog, Long> 
	implements IOperationLogManager 
{
    @Override
    protected OperationLog newEntity()
    {
        return new OperationLog();
    }
}

