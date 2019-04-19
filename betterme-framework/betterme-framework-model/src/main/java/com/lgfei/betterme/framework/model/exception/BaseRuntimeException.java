package com.lgfei.betterme.framework.model.exception;

public class BaseRuntimeException extends RuntimeException
{
    private static final long serialVersionUID = 5429348057444636065L;
    
    private String errorCode;
    
    private String errorMsg;
    
    public String getErrorCode()
    {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }
    
    public String getErrorMsg()
    {
        return errorMsg;
    }
    
    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }
    
    public BaseRuntimeException(String errorCode, String errorMsg)
    {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public BaseRuntimeException(String errorCode, String errorMsg, Throwable e)
    {
        super(errorMsg, e);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
}
