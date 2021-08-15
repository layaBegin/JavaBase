package com.heima.service;

import com.heima.entity.Student;

public interface StudentService {
    int deleteStudent(Integer id);
    Student findById(Integer id);
}
