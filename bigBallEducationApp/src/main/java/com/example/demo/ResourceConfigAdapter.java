package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class ResourceConfigAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
        //获取文件的真实路径
        //String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\Education\\img\\";
        String path = System.getProperty("user.dir")+"/src/main/resources/static/Education/img/";
        path="F://imgs/";
        String os = System.getProperty("os.name");


        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/imgs/**").
                    addResourceLocations("file:"+path);
        }else{//linux和mac系统
            registry.addResourceHandler("/imgs/**").
                    addResourceLocations("file:"+path);
        }
        super.addResourceHandlers(registry);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(new AppInterceptor()).addPathPatterns("/**").excludePathPatterns("/ForAdmin.html","/login");
//        super.addInterceptors(registry);
    }

}
