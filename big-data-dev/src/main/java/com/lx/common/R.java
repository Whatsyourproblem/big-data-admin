package com.lx.common;


import java.io.Serializable;

/**
 * 公共的返回值对象
 */
public class R<T> implements Serializable {



    private int code;

    private String msg;

    private T data;

    public static <T> R<T> ok() {
        return restResult(null, 200, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, 200, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, 200, msg);
    }

    public static <T> R<T> fail() {
        return restResult(null, 400, null);
    }

    public static <T> R<T> fail(String msg) {
        return restResult(null, 400, msg);
    }

    public static <T> R<T> fail(T data) {
        return restResult(data, 400, null);
    }

    public static <T> R<T> fail(T data, String msg) {
        return restResult(data, 400, msg);
    }

    public static <T> R<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
