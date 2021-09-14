package com.heima.web;

import com.heima.domain.User;
import com.heima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String findAllUser(HttpServletRequest request) throws ServletException, IOException {
        List<User> allUer = userService.findAllUer();
        for (User user : allUer) {
            System.out.println("===allUser"+user);

        }
        request.setAttribute("listUser",allUer);
        return "user-list";

    }

    @RequestMapping("/save")
    public String save(User user){
        userService.save(user);
        //请求重定向返回用户列表，返回的字符串redirect，forward 都是不经过视图解析器
        return "redirect:/user/list";
    }

}
