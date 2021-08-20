package com.heima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex")
public class Demo05ExceptionController {

    @RequestMapping("/find")
    public String getName(String name){
        if ("zhangshan".equals(name)){
            throw new RuntimeException("这个名字已使用");
        }
        return "success";
    }
}
