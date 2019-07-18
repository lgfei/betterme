package com.lgfei.betterme.framework.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgfei.betterme.framework.api.IBaseController;
import com.lgfei.betterme.framework.core.service.IBaseService;
import com.lgfei.betterme.framework.model.constants.NumberPool;
import com.lgfei.betterme.framework.model.entity.BaseEntity;
import com.lgfei.betterme.framework.model.vo.BatchRequestVO;
import com.lgfei.betterme.framework.model.vo.ListResponseVO;
import com.lgfei.betterme.framework.model.vo.RequestVO;
import com.lgfei.betterme.framework.model.vo.ResponseVO;

public abstract class BaseController<S extends IBaseService<T, K>, T extends BaseEntity<K>, K>
        implements IBaseController<T, K> {
    protected static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    private static final int BATCH_SIZE = 1;

    @Autowired
    protected S service;

    protected abstract T newEntity();

    @Override
    public IBaseService<T, K> getService() {
        return service;
    }

    @Override
    public boolean preHandle(RequestVO<T> reqData) {
        if (null == reqData || null == reqData.getEntity()) {
            return false;
        }
        return true;
    }

    @Override
    public Integer selectCount(RequestVO<T> reqData) {
        boolean isPass = preHandle(reqData);
        if (!isPass) {
            return NumberPool.ZERO;
        }
        QueryWrapper<T> queryWrapper = new QueryWrapper<>(reqData.getEntity());
        return getService().count(queryWrapper);
    }

    @Override
    public ListResponseVO<T> selectPage(RequestVO<T> reqData) {
        boolean isPass = preHandle(reqData);
        if (!isPass) {
            return new ListResponseVO.Builder<T>().illegal();
        }
        Page<T> pg = new Page<>();
        pg.setSize(reqData.getLimit());
        pg.setCurrent(reqData.getPage());

        QueryWrapper<T> queryWrapper = new QueryWrapper<>(reqData.getEntity());
        IPage<T> rs = getService().page(pg, queryWrapper);
        if (null == rs) {
            return new ListResponseVO.Builder<T>().ok();
        }

        ListResponseVO<T> respData = new ListResponseVO.Builder<T>().ok();
        respData.setCount(rs.getTotal());
        respData.setData(rs.getRecords());

        return respData;
    }

    @Override
    public ListResponseVO<T> select(RequestVO<T> reqData) {
        boolean isPass = preHandle(reqData);
        if (!isPass) {
            return new ListResponseVO.Builder<T>().illegal();
        }

        QueryWrapper<T> queryWrapper = new QueryWrapper<>(reqData.getEntity());
        List<T> data = getService().list(queryWrapper);

        ListResponseVO<T> respData = new ListResponseVO.Builder<T>().ok();
        respData.setData(data);

        return respData;
    }

    @Override
    public ResponseVO<T> selectOne(RequestVO<T> reqData) {
        boolean isPass = preHandle(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }

        QueryWrapper<T> queryWrapper = new QueryWrapper<>(reqData.getEntity());
        T data = getService().getOne(queryWrapper);

        ResponseVO<T> respData = new ResponseVO.Builder<T>().ok();
        respData.setData(data);

        return respData;
    }

    @Override
    public ResponseVO<T> save(RequestVO<T> reqData) {
        boolean isPass = preHandle(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }

        ResponseVO<T> respData = new ResponseVO.Builder<T>().ok();
        boolean flag = getService().save(reqData.getEntity());
        if (flag) {
            QueryWrapper<T> queryWrapper = new QueryWrapper<>(reqData.getEntity());
            T dbEntity = getService().getOne(queryWrapper);
            respData.setData(dbEntity);

            return respData;
        }
        return new ResponseVO.Builder<T>().err();
    }

    @Override
    public ResponseVO<T> saveOrUpdate(RequestVO<T> reqData) {
        boolean isPass = preHandle(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }

        ResponseVO<T> respData = new ResponseVO.Builder<T>().ok();
        boolean flag = getService().saveOrUpdate(reqData.getEntity());
        if (flag) {
            QueryWrapper<T> queryWrapper = new QueryWrapper<>(reqData.getEntity());
            T dbEntity = getService().getOne(queryWrapper);
            respData.setData(dbEntity);

            return respData;
        }
        return new ResponseVO.Builder<T>().err();
    }

    @Override
    public ResponseVO<T> update(RequestVO<T> reqData) {
        boolean isPass = preHandle(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }
        T entity = reqData.getEntity();
        if (null == entity.getId()) {
            LOG.warn("entity.id is null");
            return new ResponseVO.Builder<T>().illegal();
        }
        T wrapper = newEntity();
        wrapper.setId(entity.getId());
        UpdateWrapper<T> updateWrapper = new UpdateWrapper<>(wrapper);
        boolean flag = getService().update(entity, updateWrapper);
        if (flag) {
            T dbEntity = getService().getOne(updateWrapper);
            ResponseVO<T> result = new ResponseVO.Builder<T>().ok();
            result.setData(dbEntity);

            return result;
        }
        return new ResponseVO.Builder<T>().err();
    }

    @Override
    public ResponseVO<T> remove(RequestVO<T> reqData) {
        boolean isPass = preHandle(reqData);
        if (!isPass) {
            return new ResponseVO.Builder<T>().illegal();
        }
        ResponseVO<T> respData = new ResponseVO.Builder<T>().ok();

        T entity = reqData.getEntity();
        QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
        boolean flag = getService().remove(queryWrapper);
        if (flag) {
            respData.setData(entity);
            return respData;
        }
        return new ResponseVO.Builder<T>().err();
    }

    @Override
    public ResponseVO<T> batchSave(@RequestBody BatchRequestVO<T> reqData) {
        if (null == reqData) {
            LOG.warn("reqData is null");
            return new ResponseVO.Builder<T>().illegal();
        }
        // insert
        List<T> inserted = reqData.getInserted();
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
        List<T> updated = reqData.getUpdated();
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
        List<T> deleted = reqData.getDeleted();
        if (!CollectionUtils.isEmpty(deleted)) {
            for (T entity : deleted) {
                QueryWrapper<T> queryWrapper = new QueryWrapper<>(entity);
                getService().remove(queryWrapper);
            }
        }
        return new ResponseVO.Builder<T>().ok();
    }

    /*
     * @RequestMapping(value = "/", method = RequestMethod.GET) public String
     * getTemplate() { RequestMapping requestMapping =
     * this.getClass().getAnnotation(RequestMapping.class); if (null ==
     * requestMapping) { return "index"; } String[] values = requestMapping.value();
     * if (null == values || values.length == MyNumbers.ZERO) { return "index"; }
     * String module = values[0]; if (null == module || module.length() ==
     * MyNumbers.ZERO) { return "index"; } if (module.startsWith("/")) { module =
     * module.substring(MyNumbers.ONE); } return new
     * StringBuilder(module).append("/index").toString(); }
     */
}
