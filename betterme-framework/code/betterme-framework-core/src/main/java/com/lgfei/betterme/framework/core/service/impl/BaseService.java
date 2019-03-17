package com.lgfei.betterme.framework.core.service.impl;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgfei.betterme.framework.core.mpper.IBaseMapper;
import com.lgfei.betterme.framework.core.service.IBaseService;

public abstract class BaseService<I, T> extends ServiceImpl<IBaseMapper<T>, T> implements IBaseService<I, T>
{
    protected abstract IBaseMapper<T> getMapper();
    
    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize)
    {
        String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
        try (SqlSession batchSqlSession = sqlSessionBatch())
        {
            int i = 0;
            for (T anEntityList : entityList)
            {
                batchSqlSession.insert(sqlStatement, anEntityList);
                if (i >= 1 && i % batchSize == 0)
                {
                    batchSqlSession.flushStatements();
                }
                i++;
            }
            batchSqlSession.flushStatements();
        }
        return true;
    }
    
}
