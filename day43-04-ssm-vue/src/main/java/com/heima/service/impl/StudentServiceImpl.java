package com.heima.service.impl;

import com.heima.dao.StudentDao;
import com.heima.entity.Student;
import com.heima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAllStudent() {

        return studentDao.findAllStudent();
    }

    @Override
    public Integer saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }
}
