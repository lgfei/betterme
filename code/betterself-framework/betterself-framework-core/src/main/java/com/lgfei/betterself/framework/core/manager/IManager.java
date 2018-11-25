package com.lgfei.betterself.framework.core.manager;

import com.lgfei.betterself.framework.model.Query;
import com.lgfei.betterself.framework.model.vo.PageResultVO;
import com.lgfei.betterself.framework.model.vo.PageVO;
import com.lgfei.betterself.framework.model.vo.ResultVO;

public interface IManager<T, K>
{
    PageResultVO<T> selectByPage(Query query, PageVO page);
    
    ResultVO<T> selectById(K id);
}
