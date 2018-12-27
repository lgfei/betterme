package com.lgfei.betterme.framework.core.manager;

import com.lgfei.betterme.framework.model.Query;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;
import com.lgfei.betterme.framework.model.vo.ResultVO;

public interface IManager<T, K>
{
    PageResultVO<T> selectByPage(Query query, PageVO page);
    
    ResultVO<T> selectById(K id);
}
