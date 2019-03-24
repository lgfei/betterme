package com.lgfei.betterme.framework.core.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.core.service.IBaseService;
import com.lgfei.betterme.framework.model.entity.BaseEntity;
import com.lgfei.betterme.framework.model.enums.ResultCodeEnum;
import com.lgfei.betterme.framework.model.exception.BaseRuntimeException;
import com.lgfei.betterme.framework.model.vo.BatchDatasVO;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;
import com.lgfei.betterme.framework.model.vo.ResultVO;

public abstract class BaseManager<S extends IBaseService<T, K>, T extends BaseEntity<K>, K> implements IBaseManager<T, K>
{
    private static final Logger LOG = LoggerFactory.getLogger(BaseManager.class);
    
    private static final int BATCH_SIZE = 1;
    
    protected abstract T newEntity();
    
    @Autowired
    protected S service;
    
    @Override
    public IBaseService<T, K> getService()
    {
        return service;
    }
    
    @SuppressWarnings("unchecked")
    protected Object huandleParams(String params)
    {
        try
        {
            T entity = newEntity();
            JSONObject json = JSONObject.parseObject(params);
            return (T)json.toJavaObject(entity.getClass());
        }
        catch (Exception e)
        {
            LOG.error(" param:{},转化json异常", params);
            throw new BaseRuntimeException(ResultCodeEnum.INVALID_PARAM.getCode(), e.getMessage(), e);
        }
        
    }
    
    @Override
    public Integer selectCount(T entity, String params)
    {
        try
        {
            QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
            return getService().count(queryWrapper);
        }
        catch (Exception e)
        {
            LOG.error("求总数异常：", e);
            throw new BaseRuntimeException(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), e);
        }
    }
    
    @Override
    public PageResultVO<T> selectPage(T entity, PageVO page, String params)
    {
        try
        {
            Page<T> pg = new Page<>();
            pg.setSize(page.getPageSize());
            pg.setCurrent(page.getPageNum());
            
            QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
            IPage<T> rs = getService().page(pg, queryWrapper);
            if (null == rs)
            {
                return new PageResultVO<T>();
            }
            
            PageResultVO<T> pageResultVo = new PageResultVO<>();
            pageResultVo.setTotal(rs.getTotal());
            pageResultVo.setRows(rs.getRecords());
            
            return pageResultVo;
        }
        catch (Exception e)
        {
            LOG.error("分页查询异常：", e);
            throw new BaseRuntimeException(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), e);
        }
    }
    
    @Override
    public List<T> select(T entity, String params)
    {
        try
        {
            QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
            return getService().list(queryWrapper);
        }
        catch (Exception e)
        {
            LOG.error("普通查询异常：", e);
            throw new BaseRuntimeException(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), e);
        }
    }
    
    @Override
    public T selectOne(T entity, String params)
    {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
        try
        {
            return getService().getOne(queryWrapper);
        }
        catch (Exception e)
        {
            LOG.error("单个查询异常：", e);
            throw new BaseRuntimeException(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), e);
        }
    }
    
    @Override
    public ResultVO<T> save(T entity, String params)
    {
        try
        {
            ResultVO<T> result = new ResultVO.Builder<T>().ok();
            boolean flag = getService().save(entity);
            if (flag)
            {
                QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
                T dbEntity = getService().getOne(queryWrapper);
                result.setData(dbEntity);
                return result;
            }
            return new ResultVO.Builder<T>().err();
        }
        catch (Exception e)
        {
            LOG.error("单个保存异常：", e);
            throw new BaseRuntimeException(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), e);
        }
    }
    
    @Override
    public ResultVO<T> saveOrUpdate(T entity, String params)
    {
        try
        {
            ResultVO<T> result = new ResultVO.Builder<T>().ok();
            boolean flag = getService().saveOrUpdate(entity);
            if (flag)
            {
                QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
                T dbEntity = getService().getOne(queryWrapper);
                result.setData(dbEntity);
                return result;
            }
            return new ResultVO.Builder<T>().err();
        }
        catch (Exception e)
        {
            LOG.error("单个保存或修改异常：", e);
            throw new BaseRuntimeException(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), e);
        }
    }
    
    @Override
    public ResultVO<T> update(T entity, String params)
    {
        try
        {
            ResultVO<T> result = new ResultVO.Builder<T>().ok();
            if (null == entity.getId())
            {
                LOG.warn("entity.id is null");
                return new ResultVO.Builder<T>().illegal();
            }
            T wrapper = newEntity();
            wrapper.setId(entity.getId());
            UpdateWrapper<T> updateWrapper = new UpdateWrapper<>(wrapper);
            boolean flag = getService().update(entity, updateWrapper);
            if (flag)
            {
                T dbEntity = getService().getOne(updateWrapper);
                result.setData(dbEntity);
                return result;
            }
            return new ResultVO.Builder<T>().err();
        }
        catch (Exception e)
        {
            LOG.error("单个修改异常：", e);
            throw new BaseRuntimeException(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), e);
        }
    }
    
    @Override
    public ResultVO<T> remove(T entity, String params)
    {
        try
        {
            ResultVO<T> result = new ResultVO.Builder<T>().ok();
            QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
            boolean flag = getService().remove(queryWrapper);
            if (flag)
            {
                result.setData(entity);
                return result;
            }
            return new ResultVO.Builder<T>().err();
            
        }
        catch (Exception e)
        {
            LOG.error("删除异常：", e);
            throw new BaseRuntimeException(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), e);
        }
    }
    
    @Override
    public ResultVO<T> batchSave(BatchDatasVO<T> datas, String params)
    {
        if (null == datas)
        {
            LOG.warn("datas is null");
            return new ResultVO.Builder<T>().illegal();
        }
        try
        {
            // insert
            List<T> inserted = datas.getInserted();
            if (!CollectionUtils.isEmpty(inserted))
            {
                //            for (T entity : inserted)
                //            {
                //                getService().save(entity);
                //            }
                int count = 0;
                int len = inserted.size();
                do
                {
                    int batchSize = BATCH_SIZE;
                    if (len - count < BATCH_SIZE)
                    {
                        batchSize = len - count;
                    }
                    List<T> entityList = inserted.subList(count, count + batchSize);
                    getService().saveBatch(entityList, batchSize);
                    count = count + batchSize;
                } while (count < len);
            }
            // update
            List<T> updated = datas.getUpdated();
            if (!CollectionUtils.isEmpty(updated))
            {
                //            for (T entity : updated)
                //            {
                //                getService().updateById(entity);
                //            }
                int count = 0;
                int len = updated.size();
                do
                {
                    int batchSize = BATCH_SIZE;
                    if (len - count < BATCH_SIZE)
                    {
                        batchSize = len - count;
                    }
                    List<T> entityList = updated.subList(count, count + batchSize);
                    getService().updateBatchById(entityList, batchSize);
                    count = count + batchSize;
                } while (count < len);
            }
            // delete
            List<T> deleted = datas.getDeleted();
            if (!CollectionUtils.isEmpty(deleted))
            {
                for (T entity : deleted)
                {
                    QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
                    getService().remove(queryWrapper);
                }
            }
            return new ResultVO.Builder<T>().ok();
        }
        catch (Exception e)
        {
            LOG.error("批量保存(增删改)异常：", e);
            throw new BaseRuntimeException(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage(), e);
        }
    }
    
}
