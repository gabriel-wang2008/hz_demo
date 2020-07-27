package com.example.demo.controller;


import com.example.demo.common.Results;
import com.example.demo.config.PersonConfig;
import com.example.demo.viewObject.UserViewObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Stream;

/**
 * DefaultController
 *
 * @blame Android Team
 */
@Slf4j
@RestController
@RequestMapping("index")
public class DefaultController {
    @Value("${server.address}")
    private String address;
    @Value("${server.port}")
    private String port;

    @Value("${xxx:-1}")
    private String[] xxx;

    @Value("${yyy:-1}")
    private int[] yyy;

    @Value("${yyy:-1}")
    private List<String> yyy2;

    @Value("#{'${yyy:-1}'.split(',')}")
    private List<String> yyy22;

    @Value("${zzz:-1}")
    private List<String> zzz;

    @Value("${test.str}")
    private String str;

    @Value("${test.strV2}")
    private String strV2;

    @Value("${test.strV3}")
    private String strV3;

    @Value("${person.last-name}")
    private String lastName;


    @Value("#{${maps}}")
    private Map<String, String> maps;

    //   @Value("#{${lists}}")
    private List<String> lists;

    @Value("#{${listsV2}}")
    private List<String> listsV2;

    @Autowired
    private PersonConfig config;

    @Autowired
    private Environment env;

    @Autowired
    private ObjectMapper objectMapper;

    public DefaultController() {

        Map<String, String> getenv = System.getenv();
        Properties properties = System.getProperties();
//        String[] defaultProfiles = env.getDefaultProfiles();
    }

    @GetMapping("{id}")
    public Object ind1exV1(@PathVariable String id) {
        log.info(config.getLastName());
        ArrayList<String> objects = Lists.newArrayList();
        objects.add("1");
        objects.add("a");
        System.out.println(Stream.of(xxx).anyMatch(it -> Objects.equal("a", it)));
        Double a = 100050000.00;
        Double b = 100010000.00;
        Double c = (a - b) / b;
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("test", config);
        UserViewObject userViewObject = new UserViewObject();
        userViewObject.setName("V1");
        userViewObject.setId(id);
        return userViewObject;
    }


    @GetMapping("v2/{id}")
    public Object ind1exV2(@PathVariable String id) {
        log.info(config.getLastName());
        ArrayList<String> objects = Lists.newArrayList();
        objects.add("1");
        objects.add("a");
        System.out.println(Stream.of(xxx).anyMatch(it -> Objects.equal("a", it)));
        Double a = 100050000.00;
        Double b = 100010000.00;
        Double c = (a - b) / b;
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("test", config);
        UserViewObject userViewObject = new UserViewObject();
        userViewObject.setName("V2");
        userViewObject.setId(id);
        return userViewObject;
    }

    @PostMapping("/")
    public Object post(@RequestBody Object data) {
        log.info("data:{} ", data);
        return Results.ok(data);
    }


    @GetMapping("/a/b")
    public Map<String, Object> index() {
        System.out.println("/index");
        return null;
    }

//    @GetMapping("/")
//    public Map<String, Object> indexV2()  {
//        System.out.println("indexV2");
//        return null;
//    }
}
