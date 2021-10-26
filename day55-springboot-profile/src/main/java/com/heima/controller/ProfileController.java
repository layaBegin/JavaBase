package com.heima.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @RequestMapping("/profile")
    public String profileTest(){

        return "激活profile";
    }
}
