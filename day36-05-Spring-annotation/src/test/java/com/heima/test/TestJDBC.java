package com.heima.test;

import com.heima.entity.Student;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestJDBC {

    @Test
    public void testFindOne() {
        //1.创建数据源：使用Spring提供的数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setUrl("jdbc:mysql:///day36");
        ds.setDriverClassName("com.mysql.jdbc.Driver");

        //2.创建JdbcTemplate对象，传入数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);

        //3.调用JdbcTemplate的方法访问数据库，查询一条记录。参数1：SQL语句，参数2：映射对象，参数3：要替换的一个或多个占位符
        //RowMapper是一个接口，作用：将结果集封装成一个实体类对象。我们使用它提供的实现类
        //BeanPropertyRowMapper是RowMap接口的实现类，前提：表的列名与实体类的属性名相同，参数就是要封装的实体类类型
        Student student = jdbcTemplate.queryForObject("select * from student where id=?", new BeanPropertyRowMapper<>(Student.class), 1);
        System.out.println(student);

    }
}
