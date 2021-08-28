package com.heima.dao;

import com.heima.entity.Contact;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ContactDao {

    @Select("select * from contact")
    List<Contact> findAll();
}
