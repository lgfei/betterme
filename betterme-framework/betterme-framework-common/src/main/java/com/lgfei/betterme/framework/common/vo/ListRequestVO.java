package com.lgfei.betterme.framework.common.vo;

import java.util.List;

public class ListRequestVO<T> extends BaseRequestVO {
    private static final long serialVersionUID = 9193549160682853138L;

    private List<T> entityList;

    public List<T> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<T> entityList) {
        this.entityList = entityList;
    }

}
