package com.heima.dao;

import com.heima.entity.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptDao {
    @Select("select * from dept")
    List<Dept> findAllDept();
}
