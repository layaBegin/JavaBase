package com.heima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 上传文件的控制器
 */
@Controller
public class UploadController {
    /**
     * 上传文件方法
     * @param photo 参数名必须与表单中文件域的名字要一致
     * @return
     */
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, MultipartFile photo, String username) throws IOException {
        System.out.println("用户名：" + username);
        //1. 获取上传的文件名
        String filename = photo.getOriginalFilename();
        //获取服务器真实的地址: 请求对象 -> 上下文对象 -> 方法获取真实地址
        String realPath = request.getServletContext().getRealPath("/img/");
        System.out.println("服务器真实地址：" + realPath);
        //2. 写入文件，参数是一个文件对象。
        photo.transferTo(new File(realPath, filename));
        System.out.println("上传文件:"+ filename +"成功,路径:"+ realPath);
        return "success";
    }
}