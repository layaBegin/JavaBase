package com.heima.controller;

import com.heima.entity.Account;
import com.heima.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller // 放入容器
@RequestMapping("/account")  //模块地址
public class Demo04AccountController {

    /**
     * 数组型参数的绑定，直接指定多个同名值就可以了
     * @param id
     * @return
     */
    @RequestMapping("/array")
    public String delete(Integer[] id){
        System.out.println(Arrays.toString(id));

        return "success";
    }

    /**
     * list 集合类型的参数绑定：直接指定多个同名的值就可以
     * 方法的形参上必须使用@RequestParam 指定请求参数
     * @param id
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam List<Integer> id){
        System.out.println("集合：" + id);

        return "success";
    }


    @RequestMapping("/account")
    public String account(Account account){
        System.out.println("account：" + account);
        System.out.println(account.getName());
        return "success";
    }

    @RequestMapping("/add")
    public String add(Account account){
        System.out.println("account：" + account);
        System.out.println(account.getName());
        return "success";
    }

    @RequestMapping("/user")
    public String update(User user) {
        //会自动封装对象所有的属性值
        System.out.println(user);
        return "success";
    }

    /**
     * required 属性
     *  默认是true，表示这个参数必须要有，如果没有提供报400
     *  设置成false，没有就为null
     *  defaultValue 属性：
     *    如果没有指定值，默认是NULL，可以给它指定一个默认值
     */
    @RequestMapping("/find")
    public String find(@RequestParam(name = "name", required = false, defaultValue = "NewBoy") String username) {
        System.out.println("用户名：" + username);
        return "success";
    }

    @RequestMapping("/body")
    public String body(@RequestBody String body) {
        System.out.println("请求体：" + body);
        return "success";
    }

    @RequestMapping("/header")
    public String header(@RequestHeader("user-agent") String header){
        System.out.println("请求头："+ header);
        return "success";
    }

    @RequestMapping("/cookie")
    public String cookie(@CookieValue("JSESSIONID") String header){
        System.out.println("请求头："+ header);
        return "success";
    }
}
