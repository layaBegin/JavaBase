package com.heima.intercerpter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


public class AccountIntercerpter implements HandlerInterceptor {
    /**
     * 前置通知
     * @param request
     * @param response
     * @param handler handerMethod对象
     * @return 返回true 执行处理器；返回false，不在执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1前置通知");
        return true;
    }

    /**
     * 后置通知
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 处理器返回的 ModelAndView对象
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("1后置通知");
       /* HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        System.out.println("处理器方法名字："+  method.getName());
        System.out.println("处理器对象："+modelAndView);*/
    }

    /**
     * 最终通知
     * @param request
     * @param response
     * @param handler
     * @param ex 如果处理器中抛出了异常，这个就是那个异常
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("1最终稿通知");
        /*if (ex != null){
            System.out.println("处理器中出现异常"+ex.getMessage());
        }*/
    }
}
