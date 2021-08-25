package com.heima.service.impl;

import com.heima.dao.DeptDao;
import com.heima.entity.Dept;
import com.heima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findAllDept() {

        return deptDao.findAllDept();
    }
}
