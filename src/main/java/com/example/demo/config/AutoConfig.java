package com.example.demo.config;

import com.example.demo.filter.SimpleFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AutoConfig
 *
 * @blame Android Team
 */
@Configuration
public class AutoConfig {
//    @Bean
//    public FilterRegistrationBean<SimpleFilter> filterRegistration() {
//        FilterRegistrationBean<SimpleFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(new SimpleFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("simpleFilter");
//        registration.setOrder(1);
//        return registration;
//    }
}
