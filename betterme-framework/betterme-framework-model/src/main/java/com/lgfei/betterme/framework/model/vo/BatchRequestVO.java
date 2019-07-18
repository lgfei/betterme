package com.lgfei.betterme.framework.model.vo;

import java.util.List;

public class BatchRequestVO<T> extends BaseRequestVO {
    private static final long serialVersionUID = 9193549160682853138L;

    private List<T> inserted;

    private List<T> updated;

    private List<T> deleted;

    public List<T> getInserted() {
        return inserted;
    }

    public void setInserted(List<T> inserted) {
        this.inserted = inserted;
    }

    public List<T> getUpdated() {
        return updated;
    }

    public void setUpdated(List<T> updated) {
        this.updated = updated;
    }

    public List<T> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<T> deleted) {
        this.deleted = deleted;
    }

}
