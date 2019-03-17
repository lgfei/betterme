package com.lgfei.betterme.framework.core.manager;

import java.util.List;

import com.lgfei.betterme.framework.model.vo.BatchDatasVO;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;
import com.lgfei.betterme.framework.model.vo.ResultVO;

public interface IBaseManager<I, T>
{
    Integer selectCount(T entity, String params);
    
    PageResultVO<T> selectPage(T entity, PageVO page, String params);
    
    List<T> select(T entity, String params);
    
    T selectOne(T entity, String params);
    
    ResultVO<T> save(T entity, String params);
    
    ResultVO<T> saveOrUpdate(T entity, String params);
    
    ResultVO<T> update(T entity, String params);
    
    ResultVO<T> remove(T entity, String params);
    
    ResultVO<T> batchSave(BatchDatasVO<T> datas, String params);
}
