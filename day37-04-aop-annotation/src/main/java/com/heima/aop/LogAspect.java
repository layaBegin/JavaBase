package com.heima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@Component //将切面类放入容器
@Aspect //这是一个切面类
public class LogAspect {


    @Pointcut("execution(* com.heima.service..*.*(..))")
    public void pt(){

    }
    @Before("pt()")
    public void before(){
        System.out.println("前置通知");
    }


    @AfterReturning("pt()")
    public void afterReturning(){
        System.out.println("后置通知");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        System.out.println("异常通知");
    }

    //注解中最终通知在 后置通知前执行
    @After("pt()")
    public void after(){
        System.out.println("最终通知");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("--环绕前置");
            result = joinPoint.proceed();
            System.out.println("--环绕后置");

        }catch (Throwable throwable) {
            System.out.println("--环绕异常");

            throwable.printStackTrace();
        } finally {
            System.out.println("--环绕最终");

        }
        return result;
    }

}
