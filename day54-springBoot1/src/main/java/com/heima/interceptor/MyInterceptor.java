package com.heima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//第一步: 自定义拦截器实现HandlerInterceptor接口
public class MyInterceptor implements HandlerInterceptor {
    //拦截目标方法前，返回值代表是否放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=======前置方法：preHandle=============");
        return true; //true代表放行
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========执行完毕目标资源后置方法：postHandle==============");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========最终通知:afterCompletion==============");
    }
}
