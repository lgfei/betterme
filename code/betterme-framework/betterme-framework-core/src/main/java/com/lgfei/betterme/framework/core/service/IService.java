package com.lgfei.betterme.framework.core.service;

import java.util.List;

import com.lgfei.betterme.framework.model.Query;
import com.lgfei.betterme.framework.model.vo.PageVO;

public interface IService<T, K>
{
    Integer selectCount(Query query);
    
    List<T> selectByPage(Query query, PageVO page);
    
    T selectById(K id);
}
