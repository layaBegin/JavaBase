package com.heima.intercepter;

import com.heima.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 前置通知，
     * 判断会话域中是否有用户的信息，有就放行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            String requestURI = request.getRequestURI();
            System.out.println("请求的URI："+requestURI);
            System.out.println("拦截到非法用户："+request.getRemoteAddr());
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;
        }else {
            return true;
        }
    }
}
