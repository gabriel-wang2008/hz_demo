package com.example.demo.controller;

import com.example.demo.util.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * GlobalErrorController
 *
 * @blame Android Team
 */
@Controller
public class GlobalErrorController extends AbstractErrorController {

    private static final String ERROR_PATH = "/error";
    protected Log log = LogFactory.getLog("GlobalErrorController");

    @Autowired
    private ErrorAttributes errorAttributes;


    public GlobalErrorController() {
        super(new DefaultErrorAttributes());
    }

    //@RequestMapping("/error")
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }

        return "index";
    }

    @RequestMapping(ERROR_PATH)
    @ResponseBody
    public Object getErrorPath(HttpServletRequest request, HttpServletResponse response) {
//        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
//        Throwable cause = getCause(request);
//        int status = (Integer) model.get("status");
//        String message = (String) model.get("message");
//        String errorMessage = (String) model.get("message");
//        log.info(status + "," + message);
//        response.setStatus(status);
//        Map error = new HashMap();
//        error.put("success", false);
//        error.put("message", message);
//        responseOutWithJson(response, error);

        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> attr = Collections.unmodifiableMap(getErrorAttributes(request, false));
        HttpStatus status = getStatus(request);
        HashMap<Object, Object> result = Maps.newHashMap();
        result.put("status", status.value());
        result.put("data", String.valueOf(attr.getOrDefault("message", "error")));
        return result;
    }

//    private Integer getStatus(HttpServletRequest request) {
//        //固定写法
//        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (status != null) {
//            return status;
//        }
//        return 500;
//    }

    private Throwable getCause(HttpServletRequest request) {
        return null;
    }

    protected void responseOutWithJson(HttpServletResponse response,
                                       Object responseObject) {
        //将实体对象转换为JSON Object转换
        ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            String jsonObject = JsonUtils.toString(responseObject);
            out = response.getWriter();
            out.append(jsonObject);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @Override
    protected ModelAndView resolveErrorView(HttpServletRequest request, HttpServletResponse response, HttpStatus status, Map<String, Object> model) {
        return super.resolveErrorView(request, response, status, model);
    }
}
