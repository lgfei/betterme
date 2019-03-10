package com.lgfei.betterme.framework.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;
import com.lgfei.betterme.framework.core.service.IBaseService;

public abstract class BaseService<T> extends ServiceImpl<IBaseMapper<T>, T> implements IBaseService<T>
{
    protected abstract IBaseMapper<T> getMapper();
}
