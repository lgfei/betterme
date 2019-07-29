package com.lgfei.betterme.admin.core.service.impl;

import com.lgfei.betterme.admin.common.entity.LogOperate;
import com.lgfei.betterme.admin.core.mapper.LogOperateMapper;
import com.lgfei.betterme.admin.core.service.ILogOperateService;
import com.lgfei.betterme.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author lgfei
 * @since 2019-07-29
 */
@Service
public class LogOperateServiceImpl extends BaseServiceImpl<LogOperateMapper, LogOperate, Long> 
    implements ILogOperateService {

}
