package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Status <T>{

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private String msg;
    private  String reason;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    private  T t;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;
}
