package com.heima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 放入容器
public class HelloController {

    /**
     * RequestMapping 指定访问地址
     * @return
     */
    @RequestMapping("/hello.do")
    public String hello(){
        System.out.println("hello springMVC");
        return "success";
    }
}
