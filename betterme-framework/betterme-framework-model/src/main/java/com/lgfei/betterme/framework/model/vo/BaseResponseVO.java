package com.lgfei.betterme.framework.model.vo;

import java.util.Map;

public class BaseResponseVO implements IResponseVO {

    private static final long serialVersionUID = 1L;

    private String code = "0";

    private String msg = "success";

    private Map<String, Object> content;

    public BaseResponseVO() {

    }

    public BaseResponseVO(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

}
