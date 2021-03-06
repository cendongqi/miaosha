package com.imooc.miaosha.result;

import lombok.Data;

/**
 * @description:
 * @author:tz
 * @date:Created in 下午2:01 2018/6/28
 */
@Data
public class Result {

    private String code;

    private String message;

    private Object data;

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public Result setCode(String code) {
        this.code = code;
        return this;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result success() {
        return success(null);
    }

    public Result success(Object data) {
        this.code = CodeMsg.SUCCESS.getCode();
        this.message = CodeMsg.SUCCESS.getMessage();
        this.data = data;
        return this;
    }
}
