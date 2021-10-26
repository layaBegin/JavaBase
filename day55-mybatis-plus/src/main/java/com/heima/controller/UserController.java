package com.heima.controller;

import com.heima.model.User;
import com.heima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> list = userService.list();
        System.out.println("list:"+list);
        return list;
    }
}
