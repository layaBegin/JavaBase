package com.heima.dao.impl;

import com.heima.dao.StudentDao;
import com.heima.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public int deleteStudent(Integer id) {
        int count = this.jdbcTemplate.update("delete from student where id=?", id);
        return count;
    }

    @Override
    public Student findById(Integer id) {
        Student student = this.jdbcTemplate.queryForObject("select * from student where id=?", new BeanPropertyRowMapper<>(Student.class),id);

        return student;
    }
}
