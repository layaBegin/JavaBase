package com.heima.controller;

import com.heima.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController = @Controller +@ResponseBody
 * @Controller
 * @ResponseBody //如果整个类中所有方法都要返回json，可以加在类上
 */

@RestController
@RequestMapping("/json")
public class Demo02_JsonController {

    /**
     * produces = "application/json" //限制返回的类型是json
     * consumes = "application/json" //限制请求的类型是json
     * @param account
     * @return
     */
    @RequestMapping(path="/find",produces = "application/json",consumes = "application/json")
    //@ResponseBody //将响应体的对象转换成json //@RequestBody 请求体中是json格式的时候加上
    public Account find(@RequestBody Account account){
        System.out.println("返回json字符串"+account);

        return account;

    }
}
