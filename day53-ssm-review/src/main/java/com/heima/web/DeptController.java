package com.heima.web;

import com.heima.domain.Dept;
import com.heima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Dept> findAllDept(){
         return deptService.findAllDept();

    }
}
