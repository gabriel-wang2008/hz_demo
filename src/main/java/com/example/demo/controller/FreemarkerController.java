package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.service.AwareService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    private AwareService awareService;

    @GetMapping("/showuser.html")
    public ModelAndView showUserInfo(long id) {
        ModelAndView view = new ModelAndView();
        Map<String, String> user = new HashMap<>();
        user.put("id", "A100");
        user.put("name", "test");
        view.addObject("user", user);
        view.setViewName("/userInfo");
        return view;
    }
}
