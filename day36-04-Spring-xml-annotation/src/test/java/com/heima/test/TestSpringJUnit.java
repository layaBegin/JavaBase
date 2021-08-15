package com.heima.test;

import com.heima.entity.Student;
import com.heima.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class TestSpringJUnit {

    @Autowired
    StudentService studentService;

    //添加操作
    @Test
    public void testdelete() {
        int count = studentService.deleteStudent(2);
        System.out.println("删除了" + count + "行记录");
    }

    //查询所有记录
    @Test
    public void testFindById() {
        Student student = studentService.findById(1);
        System.out.println("查询到学生："+ student);
    }

}
