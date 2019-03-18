package com.lgfei.betterme.framework.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;
import com.lgfei.betterme.framework.core.service.IBaseService;
import com.lgfei.betterme.framework.model.BaseModel;

public abstract class BaseService<M extends IBaseMapper<T>, T extends BaseModel<K>, K>
    extends ServiceImpl<IBaseMapper<T>, T> implements IBaseService<M, T, K>
{
    protected abstract IBaseMapper<T> getMapper();
    
}
