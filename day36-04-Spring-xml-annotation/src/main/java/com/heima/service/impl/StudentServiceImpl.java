package com.heima.service.impl;

import com.heima.dao.StudentDao;
import com.heima.entity.Student;
import com.heima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public int deleteStudent(Integer id) {
        return this.studentDao.deleteStudent(id);
    }

    @Override
    public Student findById(Integer id) {
        return this.studentDao.findById(id);
    }
}
