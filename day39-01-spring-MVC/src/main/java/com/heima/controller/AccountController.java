package com.heima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/test1")
    public String tes1(){
        System.out.println("服务器启动成功");
        return "success";
    }

    @RequestMapping("/forword")
    public String forword(){
        System.out.println("转发");
        return "forward:/pages/success.jsp";
    }

    @RequestMapping("/redirect")
    public String redirect(){
        System.out.println("重定向");
        return "redirect:/pages/success.jsp";
    }

    @RequestMapping("/model")
    public ModelAndView model(ModelAndView mv){
        System.out.println("model");
        mv.setViewName("success");
        mv.addObject("name","zhubajie").addObject("age",30);
        return mv;
    }
}
