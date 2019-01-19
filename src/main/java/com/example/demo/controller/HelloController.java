package com.example.demo.controller;


import com.example.demo.config.BConfig;
import com.example.demo.service.AwareService;
import com.example.demo.util.BeanIocFactory;
import com.example.demo.viewObject.IViewObject;
import com.example.demo.viewObject.UserViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo.do")
public class HelloController {

    @Autowired
    private IViewObject viewObject;

    @GetMapping(params = "action=sayHello")
    public Map<String, Object> sayHello()  throws Exception
    {
        String ss = "";
        Map<String, Object> result = new HashMap<>();
        result.put("id", 123456);
        result.put("name", "test");

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BConfig.class);
        AwareService service= context.getBean(AwareService.class);
            service.outputResult();
        context.close();

        return result;
    }


    @RequestMapping(params = "action=sayHello2")
    public Map<String, Object> sayHello2(@RequestParam(required = false) Integer id, @RequestParam(required = false) String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        return result;
    }


    @RequestMapping(params = "action=sayHello3")
    public IViewObject sayHello3() {
        return viewObject;
    }

    @RequestMapping(params = "action=sayHello4")
    public IViewObject sayHello4() {
        UserViewObject viewObject  = BeanIocFactory.getBean(UserViewObject.class);
        viewObject.setId(viewObject.getId() + "-changing");
        return viewObject;
    }

    @RequestMapping(params = "action=sayHello5")
    public IViewObject sayHello5() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BConfig.class);
        ctx.refresh();
        UserViewObject viewObject  = (UserViewObject)ctx.getBean("userViewObject");
        //AwareService awareService  = ctx.getBean(AwareService.class);
        viewObject.setId(viewObject.getId() + "-changing");
        return viewObject;
    }

    @RequestMapping(params = "action=sayHello6")
    public IViewObject sayHello6() {
        throw new RuntimeException("test exception");
    }
}
