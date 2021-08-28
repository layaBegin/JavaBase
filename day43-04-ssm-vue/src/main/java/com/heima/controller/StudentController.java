package com.heima.controller;

import com.heima.entity.Student;
import com.heima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAll")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }
    @PostMapping("/save")
    //如果用post方式 发送json 格式的请求，必须要设置注解@RequestBody
    public Integer saveStudent(@RequestBody Student student){
        System.out.println(student);
        return  studentService.saveStudent(student);
    }

}
