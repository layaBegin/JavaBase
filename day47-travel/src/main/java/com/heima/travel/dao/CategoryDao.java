package com.heima.travel.dao;

import com.heima.travel.domain.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryDao {

    @Select("SELECT * FROM tab_category ORDER BY cid;")
    List<Category> findAll();
}
