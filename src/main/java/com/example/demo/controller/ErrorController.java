package com.example.demo.controller;

import com.example.demo.util.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ErrorController extends AbstractErrorController {

    protected Log log = LogFactory.getLog("ErrorController");

    public ErrorController(){
        super(new DefaultErrorAttributes());
    }

    //@RequestMapping("/error")
    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/error")
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
            Throwable cause = getCause(request);
        int status = (Integer)model.get("status");
        String message = (String)model.get("message");
        String errorMessage = (String)model.get("message");
        log.info(status + ","+message);
        response.setStatus(status);
        Map error = new HashMap();
        error.put("success", false);
        error.put("message", message);
        responseOutWithJson(response, error);
        return null;
    }

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
       return super.resolveErrorView(request,response,status,model);
    }
}
