package com.lgfei.betterme.framework.model.vo;

public class PageVO implements IPageVO
{
    private static final long serialVersionUID = -8815856225820444736L;
    
    private Integer pageSize = 10;
    
    private Integer pageNum = 1;
    
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
    
}
