package com.imooc.miaosha.result;

/**
 * @description:
 * @author:tz
 * @date:Created in 下午2:05 2018/6/28
 */
public enum CodeMsg {

    SUCCESS("0000", "SUCCESS"),
    SERVER_ERROR("9999", "系统异常");

    private String code;

    private String message;

    CodeMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
