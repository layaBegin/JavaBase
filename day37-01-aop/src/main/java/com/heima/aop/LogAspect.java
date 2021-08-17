package com.heima.aop;

import java.sql.Timestamp;

public class LogAspect {


    public void before(){
        System.out.println("前置通知");
    }

    public void afterReturning(){
        System.out.println("后置通知");
    }

    public void afterThrowing(){
        System.out.println("异常通知");
    }

    public void after(){
        System.out.println("最终通知");
    }

}
