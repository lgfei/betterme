package com.lgfei.betterme.framework.common.enums;

public enum MethodTypeEnum {

    QUERY("0","query"),INSERT("1","insert"),UPDATE("2","update"),DELETE("3","delete");
    
    private String code;

    private String msg;

    private MethodTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
