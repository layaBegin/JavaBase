package com.heima.travel.service.impl;

import com.heima.travel.dao.CategoryDao;
import com.heima.travel.domain.Category;
import com.heima.travel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private RedisTemplate redisTemplate;
    //如果redis中存在，则congredis取，否则从数据库中取
    @Override
    public List<Category> findAll() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //因为applicationContext.xml 配置文件中已经配了序列化器，所以可直接把java对象放进去，会自动转换
        List<Category> categorys = (List<Category>) valueOperations.get("categorys");
        if (categorys == null){
            categorys = categoryDao.findAll();
            valueOperations.set("categorys",categorys);
        }
        return categorys;
    }
}
