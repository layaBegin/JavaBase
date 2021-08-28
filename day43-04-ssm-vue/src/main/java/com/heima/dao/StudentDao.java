package com.heima.dao;

import com.heima.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {

    @Select("select * from student")
    List<Student> findAllStudent();

    @Insert("insert into student values(0,#{name},#{sex},#{birthday},#{score})")
    Integer saveStudent(Student student);
}
