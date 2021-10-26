package com.heima.controller;

import com.heima.client.UserClient;
import com.heima.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cf")
public class OrderFeignController {
    @Autowired(required = false)
    private UserClient userClient;

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long id){
        return userClient.findOne(id);
    }
}