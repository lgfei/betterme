package com.lgfei.betterme.framework.model.vo;

public class PageVO
{
    private Integer pageSize = 10;
    
    private Integer pageNum = 1;
    
    private Integer beginRowNum = (this.pageNum - 1) * pageSize;
    
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
    
    public Integer getBeginRowNum()
    {
        return beginRowNum;
    }
    
}
