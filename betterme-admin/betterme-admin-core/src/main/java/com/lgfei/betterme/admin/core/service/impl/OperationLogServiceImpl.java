package com.lgfei.betterme.admin.core.service.impl;

import com.lgfei.betterme.admin.common.entity.OperationLog;
import com.lgfei.betterme.admin.core.mapper.OperationLogMapper;
import com.lgfei.betterme.admin.core.service.IOperationLogService;
import com.lgfei.betterme.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author lgfei
 * @since 2019-07-18
 */
@Service
public class OperationLogServiceImpl extends BaseServiceImpl<OperationLogMapper, OperationLog, Long> 
    implements IOperationLogService {

}
