package com.lgfei.betterme.framework.model.vo;

import java.util.List;

import com.lgfei.betterme.framework.model.enums.ResultCodeEnum;

public class ListResponseVO<T> extends BaseResponseVO {
    private static final long serialVersionUID = 1L;

    private Long count;

    private List<T> data;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    private ListResponseVO(Builder<T> builder) {
        super();
    }

    public static class Builder<T> {
        private String code;

        private String msg;

        public Builder<T> code(String code) {
            this.code = code;
            return this;
        }

        public Builder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ListResponseVO<T> build() {
            return new ListResponseVO<T>(this);
        }

        public ListResponseVO<T> ok() {
            this.code(ResultCodeEnum.SUCCESS.getCode()).msg(ResultCodeEnum.SUCCESS.getMsg());
            return new ListResponseVO<T>(this);
        }

        public ListResponseVO<T> err() {
            this.code(ResultCodeEnum.SYSTEM_ERROR.getCode()).msg(ResultCodeEnum.SYSTEM_ERROR.getMsg());
            return new ListResponseVO<T>(this);
        }

        public ListResponseVO<T> illegal() {
            this.code(ResultCodeEnum.INVALID_PARAM.getCode()).msg(ResultCodeEnum.INVALID_PARAM.getMsg());
            return new ListResponseVO<T>(this);
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

    }
}
