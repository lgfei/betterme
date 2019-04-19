package com.lgfei.betterme.framework.model.vo;

import java.util.List;

public class PageResultVO<T> implements IResultVO
{
    private static final long serialVersionUID = -5099200433397582582L;
    
    private List<T> rows;
    
    private Long total;
    
    public List<T> getRows()
    {
        return rows;
    }
    
    public void setRows(List<T> rows)
    {
        this.rows = rows;
    }
    
    public Long getTotal()
    {
        return total;
    }
    
    public void setTotal(Long total)
    {
        this.total = total;
    }
    
}
