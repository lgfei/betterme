package com.lgfei.betterme.framework.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.lgfei.betterme.framework.common.constants.NumberPool;
import com.lgfei.betterme.framework.common.entity.BaseEntity;
import com.lgfei.betterme.framework.common.enums.MethodTypeEnum;
import com.lgfei.betterme.framework.common.vo.BatchRequestVO;
import com.lgfei.betterme.framework.common.vo.IRequestVO;
import com.lgfei.betterme.framework.common.vo.ListRequestVO;
import com.lgfei.betterme.framework.common.vo.ListResponseVO;
import com.lgfei.betterme.framework.common.vo.RequestVO;
import com.lgfei.betterme.framework.common.vo.ResponseVO;
import com.lgfei.betterme.framework.core.service.IBaseService;

import io.swagger.annotations.ApiOperation;

public abstract class BaseController<S extends IBaseService<T, K>, T extends BaseEntity<K>, K> {
    
    private static final int BATCH_SIZE = 1;
    
    protected static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    /*protected String entityClassName;
    
    public BaseController() {
        if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
            entityClassName = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1].getTypeName();
        } else {
            entityClassName = ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[1].getTypeName();
        }
    }*/
    
    protected abstract T newEntity();
    
    /**
     * 新增时取系统编码规则，填充具体entity的业务编码
     * @param entity
     * @return
     */
    protected T fillNo(T entity) {
        return entity;
    }
    
    @Autowired
    protected S service;
    
    protected IBaseService<T, K> getService() {
        return service;
    }
    
    protected boolean checkParams(IRequestVO reqData) {
        if(null == reqData) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    protected Wrapper<T> preHandle(IRequestVO reqData, String methodType) {
        if(reqData instanceof RequestVO) {
            RequestVO<T> vo = (RequestVO<T>) reqData;
            if(MethodTypeEnum.UPDATE.getCode().equals(methodType)) {
                T entity = newEntity();
                entity.setId(vo.getEntity().getId());
                return new UpdateWrapper<>(entity);
            }
            return new QueryWrapper<>(vo.getEntity());
        }else if(reqData instanceof ListRequestVO) {
            ListRequestVO<T> vo = (ListRequestVO<T>) reqData;
            List<T> entityList = vo.getEntityList();
            if(CollectionUtils.isEmpty(entityList)) {
                LOG.warn("无法获取entityList");
                return null;
            }
            
            List<K> idList = Lists.newLinkedList();
            entityList.stream().forEach(entity -> {
                idList.add(entity.getId());
            });
           
            QueryWrapper<T> queryWrapper = new QueryWrapper<>();
            queryWrapper.in("id", idList);
            return queryWrapper;
        }else {
            LOG.warn("不支持的参数类型");
            return null;
        }
    }
    
    @ApiOperation("求总数")
    @ResponseBody
    @RequestMapping(value = "/count.json", method = { RequestMethod.POST, RequestMethod.GET })
    public Integer selectCount(@RequestBody(required=false) RequestVO<T> reqData) {
        boolean isPass = checkParams(reqData);
        if (!isPass) {
            return NumberPool.ZERO;
        }
        Wrapper<T> queryWrapper = preHandle(reqData, MethodTypeEnum.QUERY.getCode());
        if(null == queryWrapper) {
            return NumberPool.ZERO;
        }
        return getService().count(queryWrapper);
    }

    @ApiOperation("分页查询")
    @ResponseBody
    @RequestMapping(value = "/page.json", method = { RequestMethod.POST, RequestMethod.GET })
    public ListResponseVO<T> selectPage(@RequestBody(required=false) RequestVO<T> reqData) {
        boolean isPass = checkParams(reqData);
        if (!isPass) {
            return new ListResponseVO.Builder<T>().illegal();
        }
       
        Page<T> pg = new Page<>();
        pg.setSize(reqData.getLimit());
        pg.setCurrent(reqData.getPage());

        Wrapper<T> queryWrapper = preHandle(reqData, MethodTypeEnum.QUERY.getCode());
        if(null == queryWrapper) {
            return new ListResponseVO.Builder<T>().ok();
        }
        
        IPage<T> rs = getService().page(pg, queryWrapper);
        if (null == rs) {
            return new ListResponseVO.Builder<T>().ok();
        }

        ListResponseVO<T> respData = new ListResponseVO.Builder<T>().ok();
        respData.setCount(rs.getTotal());
        respData.setData(rs.getRecords());

        return respData;
    }

    @ApiOperation("普通查询")
    @ResponseBody
    @RequestMapping(value = "/list.json", method = { RequestMethod.POST, RequestMethod.GET })
    public ListResponseVO<T> selectList(@RequestBody(required=false) RequestVO<T> reqData) {
        boolean isPass = checkParams(reqData);
        if (!isPass) {
            return new ListResponseVO.Builder<T>().illegal();
        }

        Wrapper<T> queryWrapper = preHandle(reqData, MethodTypeEnum.QUERY.getCode());
        if(null == queryWrapper) {
            return new ListResponseVO.Builder<T>().ok();
        }
        List<T> data = getService().list(queryWrapper);

        ListResponseVO<T> respData = new ListResponseVO.Builder<T>().ok();
        respData.setData(data);

        return respData;
    }

    @ApiOperation("单个查询")
    @ResponseBody
    @RequestMapping(value = "/one.json", method = { RequestMethod.POST, RequestMethod.GET })
    public ResponseVO<T> selectOne(@RequestBody(required=false) RequestVO<T> reqData) {
        boolean isPass = checkParams(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }

        Wrapper<T> queryWrapper = preHandle(reqData, MethodTypeEnum.QUERY.getCode());
        if(null == queryWrapper) {
            return new ResponseVO.Builder<T>().ok();
        }
        T data = getService().getOne(queryWrapper);

        ResponseVO<T> respData = new ResponseVO.Builder<T>().ok();
        respData.setData(data);

        return respData;
    }

    @ApiOperation("单个保存")
    @ResponseBody
    @RequestMapping(value = "/save.json", method = { RequestMethod.POST })
    public ResponseVO<T> save(@RequestBody(required=false) RequestVO<T> reqData) {
        boolean isPass = checkParams(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }

        T entity = fillNo(reqData.getEntity());
        boolean flag = getService().save(entity);
        if (flag) {
            Wrapper<T> queryWrapper = preHandle(reqData, MethodTypeEnum.QUERY.getCode());
            if(null == queryWrapper) {
                return new ResponseVO.Builder<T>().ok();
            }
            T dbEntity = getService().getOne(queryWrapper);
            
            ResponseVO<T> respData = new ResponseVO.Builder<T>().ok();
            respData.setData(dbEntity);

            return respData;
        }
        return new ResponseVO.Builder<T>().err();
    }

    @ApiOperation("单个保存或修改")
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdate.json", method = { RequestMethod.POST })
    public ResponseVO<T> saveOrUpdate(@RequestBody(required=false) RequestVO<T> reqData) {
        boolean isPass = checkParams(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }

        boolean flag = getService().saveOrUpdate(reqData.getEntity());
        if (flag) {
            Wrapper<T> queryWrapper = preHandle(reqData, MethodTypeEnum.QUERY.getCode());
            if(null == queryWrapper) {
                return new ResponseVO.Builder<T>().ok();
            }
            T dbEntity = getService().getOne(queryWrapper);
            
            ResponseVO<T> respData = new ResponseVO.Builder<T>().ok();
            respData.setData(dbEntity);

            return respData;
        }
        return new ResponseVO.Builder<T>().err();
    }

    @ApiOperation("单个修改")
    @ResponseBody
    @RequestMapping(value = "/update.json", method = { RequestMethod.POST })
    public ResponseVO<T> update(@RequestBody(required=false) RequestVO<T> reqData) {
        boolean isPass = checkParams(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }
        
        T entity = reqData.getEntity();
        if (null == entity.getId()) {
            LOG.warn("entity.id is null");
            return new ResponseVO.Builder<T>().illegal();
        }
        
        Wrapper<T> updateWrapper = preHandle(reqData, MethodTypeEnum.UPDATE.getCode());
        if(null == updateWrapper) {
            return new ResponseVO.Builder<T>().ok();
        }
        boolean flag = getService().update(entity, updateWrapper);
        if (flag) {
            T dbEntity = getService().getOne(updateWrapper);
            
            ResponseVO<T> respData = new ResponseVO.Builder<T>().ok();
            respData.setData(dbEntity);

            return respData;
        }
        return new ResponseVO.Builder<T>().err();
    }

    @ApiOperation("删除")
    @ResponseBody
    @RequestMapping(value = "/remove.json", method = { RequestMethod.POST })
    public ResponseVO<T> remove(@RequestBody(required=false) RequestVO<T> reqData) {
        boolean isPass = checkParams(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }
        
        Wrapper<T> queryWrapper = preHandle(reqData, MethodTypeEnum.QUERY.getCode());
        if(null == queryWrapper) {
            return new ResponseVO.Builder<T>().ok();
        }
        boolean flag = getService().remove(queryWrapper);
        if (flag) {
            ResponseVO<T> respData = new ResponseVO.Builder<T>().ok();
            respData.setData(reqData.getEntity());
            return respData;
        }
        return new ResponseVO.Builder<T>().err();
    }
    
    @ApiOperation("批量删除")
    @ResponseBody
    @RequestMapping(value = "/removeList.json", method = { RequestMethod.POST })
    public ResponseVO<T> removeList(@RequestBody(required=false) ListRequestVO<T> listReqData) {
        boolean isPass = checkParams(listReqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }

        Wrapper<T> queryWrapper = preHandle(listReqData, MethodTypeEnum.QUERY.getCode());
        if(null == queryWrapper) {
            return new ResponseVO.Builder<T>().ok();
        }
        boolean flag = getService().remove(queryWrapper);
        if (flag) {
            return new ResponseVO.Builder<T>().ok();
        }
        return new ResponseVO.Builder<T>().err();
    }

    @ApiOperation("批量保存(增删改)")
    @ResponseBody
    @RequestMapping(value = "/batchSave.json", method = { RequestMethod.POST })
    public ResponseVO<T> batchSave(@RequestBody(required=false) BatchRequestVO<T> batchReqData) {
        boolean isPass = checkParams(batchReqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }
        // insert
        List<T> inserted = batchReqData.getInserted();
        if (!CollectionUtils.isEmpty(inserted)) {
            /*
             * for (T entity : inserted){ getService().save(entity); }
             */
            int count = 0;
            int len = inserted.size();
            do {
                int batchSize = BATCH_SIZE;
                if (len - count < BATCH_SIZE) {
                    batchSize = len - count;
                }
                List<T> entityList = inserted.subList(count, count + batchSize);
                getService().saveBatch(entityList, batchSize);
                count = count + batchSize;
            } while (count < len);
        }
        // update
        List<T> updated = batchReqData.getUpdated();
        if (!CollectionUtils.isEmpty(updated)) {
            /*
             * for (T entity : updated) { getService().updateById(entity); }
             */
            int count = 0;
            int len = updated.size();
            do {
                int batchSize = BATCH_SIZE;
                if (len - count < BATCH_SIZE) {
                    batchSize = len - count;
                }
                List<T> entityList = updated.subList(count, count + batchSize);
                getService().updateBatchById(entityList, batchSize);
                count = count + batchSize;
            } while (count < len);
        }
        // delete
        List<T> deleted = batchReqData.getDeleted();
        if (!CollectionUtils.isEmpty(deleted)) {
            for (T entity : deleted) {
                QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
                getService().remove(queryWrapper);
            }
        }
        return new ResponseVO.Builder<T>().ok();
    }

}
