package com.sm.graduation.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("username");

        if (user == null) {
            System.out.println("拦截器拦截......");
            System.out.println("preHandle ::: " + null + " ::: " + request.getRequestURL());
            response.sendRedirect("/404");
            return false;
        } else {
            System.out.println("拦截器放行......");
            System.out.println("preHandle ::: " + user + " ::: " + request.getRequestURL());
            return true;
        }
    }
}
