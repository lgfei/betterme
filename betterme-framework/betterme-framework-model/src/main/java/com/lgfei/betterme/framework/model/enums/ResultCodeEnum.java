package com.lgfei.betterme.framework.model.enums;

public enum ResultCodeEnum
{
    SYSTEM_ERROR("-1", "system error"), SUCCESS("0", "success"), INVALID_PARAM("1", "invalid param"), NO_permission("2",
        "no permission");
    
    private String code;
    
    private String desc;
    
    private ResultCodeEnum(String code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public String getDesc()
    {
        return desc;
    }
}
