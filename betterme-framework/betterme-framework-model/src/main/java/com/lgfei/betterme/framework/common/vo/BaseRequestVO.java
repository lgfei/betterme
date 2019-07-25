package com.lgfei.betterme.framework.common.vo;

import java.util.Map;

public class BaseRequestVO implements IRequestVO {

    private static final long serialVersionUID = 1L;

    private Map<String, Object> params;

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
