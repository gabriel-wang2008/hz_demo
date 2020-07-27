package com.example.demo.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new SimpleInterceptor())
                .addPathPatterns("/**")
                //org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.error
                .excludePathPatterns("/login", "/logout", "/error");
    }
}
