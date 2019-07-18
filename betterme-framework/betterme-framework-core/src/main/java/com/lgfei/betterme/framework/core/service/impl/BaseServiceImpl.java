package com.lgfei.betterme.framework.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;
import com.lgfei.betterme.framework.core.service.IBaseService;
import com.lgfei.betterme.framework.model.entity.BaseEntity;

public abstract class BaseServiceImpl<M extends IBaseMapper<T, K>, T extends BaseEntity<K>, K>
        extends ServiceImpl<IBaseMapper<T, K>, T> implements IBaseService<T, K> {
    protected static final Logger LOG = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    protected M mapper;

    @Override
    public IBaseMapper<T, K> getMapper() {
        return mapper;
    }

}
