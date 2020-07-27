package com.example.demo.controller;


import com.example.demo.config.BConfig;
import com.example.demo.service.AwareService;
import com.example.demo.util.BeanIocFactory;
import com.example.demo.viewObject.IViewObject;
import com.example.demo.viewObject.UserViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo.do")
public class HelloController {
    @Value("${server.address}")
    private String address;
    @Value("${server.port}")
    private String port;
    @Autowired
    private IViewObject viewObject;

    public HelloController() {
    }

    @GetMapping("/")
    public Map<String, Object> index(@RequestParam List<String> list, @RequestAttribute String name) throws Exception {
        System.out.println("index");
        return null;
    }

    @GetMapping(params = "action=sayHello")
    public Map<String, Object> sayHello(@RequestParam List<String> list, @RequestAttribute String name) throws Exception {
        String ss = "";
//        throw new IllegalStateException();
        Map<String, Object> result = new HashMap<>();
        result.put("id", 123456);
        result.put("name", "test");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
//        AwareService service = context.getBean(AwareService.class);
//        service.outputResult();
//        context.close();

        Object userViewObject = BeanIocFactory.getBean("userViewObject");
        Object TestConfig = BeanIocFactory.getBean("testConfig");
        Object testUsert = BeanIocFactory.getBean("testUsert");
        System.out.println("sayHello");
        return result;
    }


    @RequestMapping(params = "action=sayHello2", produces = "application/v1+json")
    public Map<String, Object> sayHello2(@RequestParam(required = false) Integer id, @RequestParam(required = false) String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("name", "sdsd888s");
//        MediaType.ALL
        return result;
    }


    @RequestMapping(params = "action=sayHello3")
    public IViewObject sayHello3() {
        return viewObject;
    }

    @RequestMapping(params = "action=sayHello4")
    public IViewObject sayHello4() {
        UserViewObject viewObject = BeanIocFactory.getBean(UserViewObject.class);
        viewObject.setId(viewObject.getId() + "-changing");
        return viewObject;
    }

    @RequestMapping(params = "action=sayHello5")
    public IViewObject sayHello5() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BConfig.class);
        ctx.refresh();
        UserViewObject viewObject = (UserViewObject) ctx.getBean("userViewObject");
        //AwareService awareService  = ctx.getBean(AwareService.class);
        viewObject.setId(viewObject.getId() + "-changing");
        return viewObject;
    }

    @RequestMapping(params = "action=sayHello6")
    public IViewObject sayHello6() {
        throw new RuntimeException("test exception");
    }

    public String getAddress() {
        return this.address;
    }

    public String getPort() {
        return this.port;
    }

    public IViewObject getViewObject() {
        return this.viewObject;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setViewObject(IViewObject viewObject) {
        this.viewObject = viewObject;
    }

    public String toString() {
        return "HelloController(address=" + this.getAddress() + ", port=" + this.getPort() + ", viewObject=" + this.getViewObject() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof HelloController)) return false;
        final HelloController other = (HelloController) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$port = this.getPort();
        final Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) return false;
        final Object this$viewObject = this.getViewObject();
        final Object other$viewObject = other.getViewObject();
        if (this$viewObject == null ? other$viewObject != null : !this$viewObject.equals(other$viewObject))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HelloController;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $port = this.getPort();
        result = result * PRIME + ($port == null ? 43 : $port.hashCode());
        final Object $viewObject = this.getViewObject();
        result = result * PRIME + ($viewObject == null ? 43 : $viewObject.hashCode());
        return result;
    }
}
