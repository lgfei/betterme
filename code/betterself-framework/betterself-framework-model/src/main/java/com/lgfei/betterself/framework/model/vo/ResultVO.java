package com.lgfei.betterself.framework.model.vo;

import com.lgfei.betterself.framework.model.enums.ResultCodeEnum;

/**
 * Hello world!
 *
 */
public class ResultVO<T>
{
    private String resultCode;
    
    private String resultMsg;
    
    private T data;
    
    public ResultVO()
    {
        super();
        this.resultCode = ResultCodeEnum.SUCCESS.getCode();
        this.resultMsg = ResultCodeEnum.SUCCESS.getDesc();
    }
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getResultMsg()
    {
        return resultMsg;
    }
    
    public void setResultMsg(String resultMsg)
    {
        this.resultMsg = resultMsg;
    }
    
    public T getData()
    {
        return data;
    }
    
    public void setData(T data)
    {
        this.data = data;
    }
    
}
