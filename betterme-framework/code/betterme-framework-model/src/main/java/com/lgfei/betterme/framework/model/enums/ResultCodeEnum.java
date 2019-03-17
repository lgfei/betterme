package com.lgfei.betterme.framework.model.enums;

public enum ResultCodeEnum
{
    SYSTEM_ERROR("-1", "SYSTEM ERROR"), SUCCESS("0", "SUCCESS"), INVALID_PARAM("1", "INVALID PARAM"), NO_PERMISSION("2",
        "no permission");
    
    private String code;
    
    private String msg;
    
    private ResultCodeEnum(String code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public String getMsg()
    {
        return msg;
    }
}
