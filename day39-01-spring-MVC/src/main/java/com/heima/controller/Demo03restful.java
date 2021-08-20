package com.heima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class Demo03restful {

    /**
     *     @RequestMapping(method = RequestMethod.GET)
     *     1,/{id} 指定变量名
     *     2，@PathVariable 参数从路径获取
     *     这些参数将放在请求域中
     * @return
     */
    @GetMapping("/{id}/{username}")
    public String get(@PathVariable Integer id,@PathVariable("username") String name){
        System.out.println("get 方式请求 id："+id + ",name:"+name);

        return "success";
    }

    @PostMapping("/{sex}")
    public String post(@PathVariable String sex){
        System.out.println("post 方式请求:"+sex);
        return "success";
    }

    /**
     * 使用put 或者delete 不支持转发，但可以使用重定向 否则会报405错误
     * @return
     */
    @PutMapping
    public String update(){
        System.out.println("更新操作");
        return "redirect:/pages/success.jsp";
    }

    /**
     * 使用put 或者delete 不支持转发，但可以使用重定向 否则会报405错误
     * @return
     */
    @DeleteMapping
    public String delete(){
        System.out.println("delete操作");
        return "redirect:/pages/success.jsp";
    }
}
