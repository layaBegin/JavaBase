package com.heima.service.impl;

import com.heima.dao.StudentDao;
import com.heima.entity.Student;
import com.heima.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int deleteStudent(Integer id) {
        return this.studentDao.deleteStudent(id);
    }

    @Override
    public Student findById(Integer id) {
        return this.studentDao.findById(id);
    }
}
