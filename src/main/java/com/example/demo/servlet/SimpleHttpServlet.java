package com.example.demo.servlet;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;



/**
 * SimpleHttpServlet
 *
 * @blame Android Team
 */
@WebServlet(name = "simpleServlet", urlPatterns = {"/simpleServlet"})
public class SimpleHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        Map<Object, Object> data = Maps.newHashMap();
        data.put("a",1);
        data.put("b","b1");
        String userJson = JSON.toJSONString(data);
        OutputStream out = resp.getOutputStream();
        out.write(userJson.getBytes("UTF-8"));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("com.wmx.servlet.UserServlet -- " + requestURL);
        resp.sendRedirect("/index.html");//浏览器重定向到服务器下的 index.html 页面
    }
}
