package com.heima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller // 放入容器
@RequestMapping("/student")  //模块地址
public class Demo03StudentController {

    @RequestMapping("/study")
    public String study(HttpServletRequest request, HttpSession session){
            request.setAttribute("name","sunwukong");
            session.setAttribute("name","baigujing");

        return "success";
    }
    /**
     *  响应对象，使用响应对象重定向
     */
    @RequestMapping("/resp")
    public void eat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("响应对象");
        response.sendRedirect(request.getContextPath() + "/pages/success.jsp");
    }

    /**
     * 使用Map、Model、ModelMap 对象
     */
    @RequestMapping("/sport")
    public String study(Map<String,Object> map){
        map.put("name","zhubajie");

        return "success";
    }

    @RequestMapping("/swim")
    public String swim(Model model){
        model.addAttribute("name","swim").addAttribute("age",30);
        return "success";
    }

    @RequestMapping("/draw")
    public String draw(ModelMap modelMap){
        modelMap.addAttribute("name","draw").addAttribute("age",10);
        return "success";
    }
}
