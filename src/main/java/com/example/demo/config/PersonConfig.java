package com.example.demo.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Configuration
@ConfigurationProperties(prefix = "person")
public class PersonConfig {
    private String lastName;
    private Integer age;
    private Boolean boss;
    private String birth;
    private String noValue = "default";
    private Map<String, String> maps;
    private Map<String, String> mapsV2;
    private List<String> lists;
    private List<String> listsV2;
//    private Dog dog = new Dog();

//    @Data
//    private static class Dog {
//        private String name;
//        private String age;
//    }
}
