package com.heima.test;

import com.heima.entity.Student;
import com.heima.service.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 从容器中获取JdbcTemplate对象直接使用
 */
public class TestDemo02 {

    ClassPathXmlApplicationContext context;
    StudentService studentService;

    //在每个测试方法前调用
    @Before
    public void init() {
        //创建Spring容器
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取模板对象
        studentService = context.getBean(StudentService.class);
    }

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

    //在每个测试方法之后关闭
    @After
    public void destory() {
        //关闭容器
        context.close();
    }
}
