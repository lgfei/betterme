package com.lgfei.betterself.framework.core.service;

import java.util.List;

import com.lgfei.betterself.framework.model.Query;
import com.lgfei.betterself.framework.model.vo.PageVO;

public interface IService<T,K>
{ 
    Integer selectCount(Query query);
    
    List<T> selectByPage(Query query,PageVO page);
    
    T selectById(K id);
}
