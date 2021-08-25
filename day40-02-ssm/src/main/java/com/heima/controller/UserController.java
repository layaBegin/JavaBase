package com.heima.controller;

import com.heima.service.UserService;
import com.heima.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView findAll(){
        List<User> userList = userService.findAll();
        return new ModelAndView("user-list","userList",userList);
    }


    @PostMapping
    public String addUser(User user){
        userService.addUser(user);
        //跳到首页，重新查询
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    @ResponseBody //加上整个可以返回整数
    public Integer deleteUser(@PathVariable Integer id){
        return  userService.deleteUser(id);

    }
}
