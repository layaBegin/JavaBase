package com.heima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 放入容器
@RequestMapping("/user")  //模块地址
public class Demo02RequestMapperingController {

    /**
     * RequestMapping 指定访问地址
     * path 可以指定多个访问地址
     * method : 限制请求的方式, GET，PUT，POST，DELETE否则报405
     * params: 限制请求的参数
     * @return
     */
    @RequestMapping(path = {"/hello","/hehe"},method = RequestMethod.GET,params = {"id=100","name"},headers = {"user=newboy"})  //完整地址为/user/hello
    public String findById(Integer id,String name){
        System.out.println("查询id为："+ id + "的用户");
        System.out.println("用户名为：" + name);
        return "success";
    }

    /**
     * RequestMapping 指定访问地址
     * @return
     */
    @RequestMapping("/save")
    public String save(){
        System.out.println("hello springMVC");
        return "success";
    }
}
