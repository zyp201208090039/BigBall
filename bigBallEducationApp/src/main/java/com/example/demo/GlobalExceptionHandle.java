package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandle {
    private static Logger logger = Logger.getLogger(String.valueOf(GlobalExceptionHandle.class));

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exception(Exception ex)
    {
        ex.printStackTrace();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code","500");
        map.put("msg","出错了");
        map.put("error",ex.toString());
        //logger.error("This is error message.");
        return  map;

    }

}
