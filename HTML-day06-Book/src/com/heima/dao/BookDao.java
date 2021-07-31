package com.heima.dao;

import org.apache.ibatis.annotations.Insert;

public interface BookDao {
    @Insert("INSERT INTO `book` VALUES(null,#{name},#{author},#{time},#{type})")
    int saveBook(com.heima.entity.Book book);
}
