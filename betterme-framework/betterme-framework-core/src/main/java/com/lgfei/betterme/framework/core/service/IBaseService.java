package com.lgfei.betterme.framework.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;

public interface IBaseService<T, K> extends IService<T> {
    IBaseMapper<T, K> getMapper();
}
