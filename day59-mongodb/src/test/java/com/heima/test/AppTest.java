package com.heima.test;

import com.heima.model.User;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    //以后你们操作mongodb使用客户端都是Mongotemplate对象
    @Autowired
    private MongoTemplate mongoTemplate;

    //增加
    @Test
    public void saveTest(){
        /*User user = new User();
        user.setId(7);
        user.setAge(18);
        user.setUsername("王五");
        mongoTemplate.save(user);*/

        User user = new User();
        user.setId(9);
        user.setAge(19);
        user.setUsername("赵六");
        mongoTemplate.insert(user);

    }


    //修改  update user set age=180 where username=wangba
    @Test
    public void updateTest(){
        //创建一个查询条件
        Query query = new Query();
        Criteria age = Criteria.where("age").lt(20);
        query.addCriteria(age);
        // 创建一个更新的对象
        Update update = new Update();
        update.set("age", 34);
        /**
         * updateMulti(Query query, Update update, Class);
         *      query: 更新语句的条件 相当于 where xxx=xxx
         *      update: 更新字段, 相当于set xxx =xx
         *      class； 对应的实体类，因为每一个实体类都对应一个集合（表）
         */
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, User.class);
        System.out.println("updateResult:"+updateResult.getModifiedCount());
    }


    //删除 相当于 delete from user where username=lisi and age>20
    @Test
    public void deleteTest(){
        Query query = new Query();
        Criteria criteria = Criteria.where("age").gt(22).and("username").is("liuba");
        query.addCriteria(criteria);

        /**
         * remove(query对象查询条件,User.class);
         */
        mongoTemplate.remove(query,User.class);
    }

    //根据主键查询
    @Test
    public void findByIdTest(){
        //User user = mongoTemplate.findById("60d3fdee56320000470070f6", User.class);
        //User user = mongoTemplate.findById(9, User.class);
        List<User> all = mongoTemplate.findAll(User.class);
        System.out.println("查询的用户："+ all);
    }

    //根据多条件查询  条件： username:以z开头 年龄 20-80
    @Test
    public void findByConditionTest(){
        //创建条件对象
        Query query = new Query();
        //regex("正则表达式") 这个是正则表达式的方法
        Criteria criteria = Criteria.where("username").regex("^z.*$").and("age").gt(21).lte(35);

        query.addCriteria(criteria);

        List<User> userList = mongoTemplate.find(query, User.class);
        System.out.println("查询的对象："+ userList);
    }


    //排序，跳过、limit
    @Test
    public void findByPageTest(){
        Query query  = new Query();
        query.skip(3);
        query.limit(2);
        query.with(Sort.by(Sort.Order.asc("age")));

        List<User> userList = mongoTemplate.find(query, User.class);
        System.out.println("集合的个数："+ userList.size());
        System.out.println("集合的内容："+ userList);
    }
}

