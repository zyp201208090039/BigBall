package com.example.demo.handle;

import com.example.demo.model.ApiResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {

    /**
     * 默认统一异常处理方法
     * @ExceptionHandler 注解用来配置需要拦截的异常类型, 也可以是自定义异常
     */
    @ExceptionHandler(Exception.class)
    // 此处可以指定返回的状态码 和 返回 结果说明
    // @ResponseStatus(reason = "exception",value = HttpStatus.BAD_REQUEST)

    public Object runtimeExceptionHandler(Exception e) {
        // 打印异常信息到控制台
        e.printStackTrace();
       // log.error("请求出现异常,异常信息为: {}", e.getMessage());
        // 使用公共的结果类封装返回结果, 这里我指定状态码为 400
        return ApiResult.build(400, e.getMessage());
    }


}
