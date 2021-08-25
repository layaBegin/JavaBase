package com.heima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("account")
public class AccountController {

    @RequestMapping("/find")
    public ModelAndView find(String name){
        System.out.println("处理器执行查找name:"+name);
        if ("zhangshan".equals(name)){
            throw new RuntimeException("用户名非法");
        }
        return new ModelAndView("success","msg","找到了");
    }
    @RequestMapping("/save")
    public String save(){
        System.out.println("执行save");
        return "success";
    }
}
