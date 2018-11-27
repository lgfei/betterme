package com.lgfei.betterme.framework.model.vo;

public class PageVO
{
    private Integer pageSize;
    
    private Integer pageNum;
    
    private Integer start;
    
    private Integer end;
    
    public Integer getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public Integer getPageNum()
    {
        return pageNum;
    }
    
    public void setPageNum(Integer pageNum)
    {
        this.pageNum = pageNum;
    }
    
    public Integer getStart()
    {
        return start;
    }
    
    public void setStart(Integer start)
    {
        this.start = start;
    }
    
    public Integer getEnd()
    {
        return end;
    }
    
    public void setEnd(Integer end)
    {
        this.end = end;
    }
    
}
