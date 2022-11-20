package com.example.helloblog.utils;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private String state;
    private String msg;
    private T data;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>();
        result.setState("200");
        result.setMsg("成功");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setState("200");
        result.setMsg("成功");
        return result;
    }


    public static <T> Result<T> success(T data,String msg) {
        Result<T> result = new Result<>(data);
        result.setState("200");
        result.setMsg(msg);
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setState(code);
        result.setMsg(msg);
        return result;
    }
}
