package com.heima.controller;

import com.heima.entity.ResultInfo;
import com.heima.entity.User;
import com.heima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ResultInfo login(@RequestBody User user, HttpSession session){
        System.out.println(user + "开始登录");
        User login = userService.login(user.getUsername(), user.getPassword());
        if (login != null){
            session.setAttribute("user",login);
            return new ResultInfo(true,"登录成功");
        }else{
            return new ResultInfo(false,"登录失败");

        }
    }

    @RequestMapping("/logout")
    public void logOut(HttpSession session){
        session.invalidate();
    }
}
