package com.heima.dao;

import com.heima.entity.Student;

import java.util.List;

public interface StudentDao {

    int deleteStudent(Integer id);
    Student findById(Integer id);

}
