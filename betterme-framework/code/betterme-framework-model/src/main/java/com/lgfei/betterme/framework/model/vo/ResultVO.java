package com.lgfei.betterme.framework.model.vo;

import com.lgfei.betterme.framework.model.enums.ResultCodeEnum;

/**
 * 返回页面结果
 *
 */
public class ResultVO<T> implements IResultVO
{
    private static final long serialVersionUID = -8955803788318315741L;
    
    private String resultCode;
    
    private String resultMsg;
    
    private T data;
    
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
    
    private ResultVO(Builder<T> builder)
    {
        super();
        this.resultCode = builder.resultCode;
        this.resultMsg = builder.resultMsg;
    }
    
    public static class Builder<T>
    {
        private String resultCode;
        
        private String resultMsg;
        
        public Builder<T> resultCode(String resultCode)
        {
            this.resultCode = resultCode;
            return this;
        }
        
        public Builder<T> resultMsg(String resultMsg)
        {
            this.resultMsg = resultMsg;
            return this;
        }
        
        public ResultVO<T> build()
        {
            return new ResultVO<>(this);
        }
        
        public ResultVO<T> ok()
        {
            this.resultCode(ResultCodeEnum.SUCCESS.getCode()).resultMsg(ResultCodeEnum.SUCCESS.getMsg());
            return new ResultVO<>(this);
        }
        
        public ResultVO<T> err()
        {
            this.resultCode(ResultCodeEnum.SYSTEM_ERROR.getCode()).resultMsg(ResultCodeEnum.SYSTEM_ERROR.getMsg());
            return new ResultVO<>(this);
        }
        
        public ResultVO<T> illegal()
        {
            this.resultCode(ResultCodeEnum.INVALID_PARAM.getCode()).resultMsg(ResultCodeEnum.INVALID_PARAM.getMsg());
            return new ResultVO<>(this);
        }
        
    }
}
