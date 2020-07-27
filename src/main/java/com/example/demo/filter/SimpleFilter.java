package com.example.demo.filter;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Order(1)
@WebFilter
public class SimpleFilter extends OncePerRequestFilter {
    private String encoding = "UTF-8";


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {

        request.setCharacterEncoding(encoding);
        System.out.println(" Simple Filter before doFilter");
        filterChain.doFilter(request, response);
        System.out.println(" Simple Filter after doFilter");
    }

}
