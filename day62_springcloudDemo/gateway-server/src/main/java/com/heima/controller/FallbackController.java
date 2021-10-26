package com.heima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallback(){
        return "您好，服务器正忙，请稍候再试。。。";
    }
}
