package com.lgfei.betterme.framework.model.vo;

import com.lgfei.betterme.framework.model.enums.ResultCodeEnum;

/**
 * 返回页面结果
 *
 */
public class ResponseVO<T> extends BaseResponseVO {
    private static final long serialVersionUID = -8955803788318315741L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ResponseVO(Builder<T> builder) {
        super();
        this.setCode(builder.code);
        this.setMsg(builder.msg);
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

        public ResponseVO<T> build() {
            return new ResponseVO<T>(this);
        }

        public ResponseVO<T> ok() {
            this.code(ResultCodeEnum.SUCCESS.getCode()).msg(ResultCodeEnum.SUCCESS.getMsg());
            return new ResponseVO<T>(this);
        }

        public ResponseVO<T> err() {
            this.code(ResultCodeEnum.SYSTEM_ERROR.getCode()).msg(ResultCodeEnum.SYSTEM_ERROR.getMsg());
            return new ResponseVO<T>(this);
        }

        public ResponseVO<T> illegal() {
            this.code(ResultCodeEnum.INVALID_PARAM.getCode()).msg(ResultCodeEnum.INVALID_PARAM.getMsg());
            return new ResponseVO<T>(this);
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
