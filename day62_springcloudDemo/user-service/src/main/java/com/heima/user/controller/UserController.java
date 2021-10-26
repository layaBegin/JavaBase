package com.heima.user.controller;

import com.heima.pojo.User;
import com.heima.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 */
@RestController
@RequestMapping("/user")
@RefreshScope //刷新配置
public class UserController {

    @Autowired
    private UserService userService;
    @Value("${test.name}")
    private String name;
    /**
     * 根据id查询用户
     */
    @GetMapping("/{id}")
    public User findOne(@PathVariable("id")Long id){
        System.out.println("配置文件中的test.name = " + name);
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return userService.findOne(id);
    }
}
