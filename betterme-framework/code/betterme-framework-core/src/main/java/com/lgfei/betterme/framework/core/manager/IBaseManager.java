package com.lgfei.betterme.framework.core.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lgfei.betterme.framework.model.vo.PageResultVO;
import com.lgfei.betterme.framework.model.vo.PageVO;

public interface IBaseManager<T>
{
    Integer selectCount(QueryWrapper<T> queryWrapper);
    
    PageResultVO<T> selectPage(PageVO pageVO, QueryWrapper<T> queryWrapper);
}
