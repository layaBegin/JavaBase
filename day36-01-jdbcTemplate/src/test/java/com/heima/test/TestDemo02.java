package com.heima.test;

import com.heima.entity.Student;
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
    JdbcTemplate jdbcTemplate;

    //在每个测试方法前调用
    @Before
    public void init() {
        //创建Spring容器
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取模板对象
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    //添加操作
    @Test
    public void testAdd() {
        int row = jdbcTemplate.update("insert into student values(null,?,?,?,?)", "唐三藏", "1990-11-23", "男", "女儿国");
        System.out.println("添加了" + row + "行记录");
    }

    //查询所有记录
    @Test
    public void testFindAll() {
        //query查询多条记录，查询所有的男生
        List<Student> students = jdbcTemplate.query("select * from student where sex=?", new BeanPropertyRowMapper<>(Student.class), "男");
        students.forEach(System.out::println);
    }

    //在每个测试方法之后关闭
    @After
    public void destory() {
        //关闭容器
        context.close();
    }
}
