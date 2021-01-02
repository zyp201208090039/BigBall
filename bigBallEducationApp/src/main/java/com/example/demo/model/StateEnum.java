package com.example.demo.model;

public enum StateEnum {
    secuccessful(100),
    failed(0),
    ;

    private  int value;
    StateEnum(int i) {
        this.value=i;
    }
    public  int getValue()
    {
        return  this.value;
    }
}
