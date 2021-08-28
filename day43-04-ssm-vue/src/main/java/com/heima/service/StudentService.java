package com.heima.service;

import com.heima.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudent();
    Integer saveStudent(Student student);
}
