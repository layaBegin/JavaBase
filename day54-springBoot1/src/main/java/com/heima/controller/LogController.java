package com.heima.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController {

    @RequestMapping("/log")
    public String testLog(){
        log.debug("===debug==");
        log.info("==info===");
        log.warn("===warn===");
        log.error("===err===");
        return "日志";

    }
}
