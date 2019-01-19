package com.example.demo.config;

import com.example.demo.service.AwareService;
import com.example.demo.viewObject.UserViewObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BConfig {
    @Bean(name = "userViewObject")
    public UserViewObject getUserInfo(){
        UserViewObject viewObject = new UserViewObject();
        viewObject.setId("B001");
        viewObject.setName("B_test");
        return  viewObject;
    }


    @Bean(name = "awareService")
    public AwareService getAwareService(){
        AwareService awareService = new AwareService();
        return  awareService;
    }
}
