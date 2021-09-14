package com.heima.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.dao.UserDao;
import com.heima.model.User;
import com.heima.model.enums.SexEnum;
import lombok.ToString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test1(){
        User user = userDao.selectById(2);
        System.out.println(user.toString());
    }

    @Test
    public void save(){
        User user1 = new User();
        user1.setName("猫娃");
        user1.setUserName("maowa");
        user1.setPassword1("123456");
        user1.setEmail("a123@gmal.com");
        user1.setAge(188);
        userDao.insert(user1);
    }

    @Test
    public void testDeleteById(){
        int row = userDao.deleteById(9);
        System.out.println("shou===:"+row);
    }
    @Test
    public void testDeleteByIds(){
        List<Integer> ids = new ArrayList<>();
        ids.add(4);
        ids.add(5);
        int row = userDao.deleteBatchIds(ids);
        System.out.println("shou===:"+row);

    }

    @Test
    public void testDeleteByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age","18");
        //必须两个条件都满足才会删除
        //DELETE FROM tb_user WHERE name = ? AND age = ?
        int row = userDao.deleteByMap(map);
        System.out.println("shou===:"+row);
    }
    @Test
    public void testDeleteByWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //DELETE FROM tb_user WHERE (name LIKE ? OR age > ?)
        wrapper.like("name","李");
        wrapper.or();
        wrapper.gt("age","25");
        userDao.delete(wrapper);
    }

    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(9L);
        user.setName("赵安是王八");
        user.setAge(97);
        int row = userDao.updateById(user);

    }

    @Test
    public void testUpdateByCondition(){
        User user = new User();
        user.setPassword1("123");
        user.setName("阿猫");
        user.setAge(97);
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("age","24");
        wrapper.likeRight("user_name","su");
        //UPDATE tb_user SET password=?, name=?, age=? WHERE (age = ? AND user_name LIKE ?)
        int row = userDao.update(user,wrapper);

    }

    /** 查询语句
     * eq( ) :  等于 =
     * ne( ) :  不等于 <>
     * gt( ) :  大于 >
     * ge( ) :  大于等于 >=
     * lt( ) :  小于 <
     * le( ) :  小于等于 <=
     * between ( ) :  BETWEEN 值1 AND 值2
     * notBetween ( ) :  NOT BETWEEN 值1 AND 值2
     * in( ) :  in
     * notIn( ) :  not in
     */
    //需求：查询user_name为lisi，年龄小于23，name：李四 ，王五里面
    //SELECT id,user_name,password,name,age,email FROM tb_user WHERE (user_name = ? AND age < ? AND name IN (?,?))
    @Test
    public void restFind1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","lisi");
        wrapper.lt("age",23);
        wrapper.in("name","李二","李四");
        List<User> userList = userDao.selectList(wrapper);
        System.out.println("查询到的数据："+ userList);
    }

    @Test
    public void restFind2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","李四");
        wrapper.or();
        wrapper.gt("age",23);
        List<User> users = userDao.selectList(wrapper);
        System.out.println("users==:"+users);
    }

    //需求2: 查询user_name = lisi and (name=李四 or name = 赵六)
    // SELECT id,user_name,password,name,age,email FROM tb_user WHERE (user_name = ? AND (name = ? OR name = ?))
    @Test
    public void restFind3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","lisi");
        wrapper.and(new Consumer<QueryWrapper<User>>() {
            @Override
            public void accept(QueryWrapper<User> wrapper) { //这里的wrapper就填写and里面的条件即可
                wrapper.eq("name","李二");
                wrapper.or();
                wrapper.eq("name","李四");
            }
        });

        List<User> userList = userDao.selectList(wrapper);
        System.out.println("查询到的数据："+ userList);
    }

    /**
     * like 相当于 like '%关键字%'
     * notLike 相当于 not like '%关键字%'
     * likeLeft 相当于 like '%关键字'
     * likeRight 相当于 like '关键字%'
     */
    //需求：user_name like 'zhang%'  likeRight
    @Test
    public void restFind4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("user_name","zhang");
        List<User> userList = userDao.selectList(wrapper);
        System.out.println("查询到的数据："+ userList);
    }


    /**
     * orderBy : 指定排序规则
     * orderByAsc : 升序排序
     * orderByDesc : 降序排序
     */
    //排序
    @Test
    public void restFindSort(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        List<User> userList = userDao.selectList(wrapper);
        System.out.println("查询到的数据："+ userList);
    }
    //查询指定的字段
    @Test
    public void restFindSelect(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","name");

        List<User> userList = userDao.selectList(wrapper);
        System.out.println("查询到的数据："+ userList);
    }

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,2);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        //selectPage 实现分页方法
        Page<User> userPage = userDao.selectPage(page, wrapper);
        System.out.println("page===="+userPage.getTotal());
    }


    //------------利用原生方法
    @Test
    public void testFindAll(){
        List<User> all = userDao.findAll();
        System.out.println("all===:"+all);
    }

    @Test
    public void testPage1(){
        Page<User> byPage = userDao.findByPage(new Page<>(1, 3), 23);
        System.out.println("page===:"+byPage.getPages());
    }


    //枚举 根据id查找一个对象
    @Test
    public void testEnum(){
        User user = userDao.selectById(1L);
        System.out.println("用户："+user);
    }

    //增加
    @Test
    public void addEnumInsertTest(){
        User user = new User();
        user.setUserName("狗娃");
        user.setPassword1("123");
        user.setEmail("1234@qq.com");
        user.setName("小狗娃");
        user.setAge(20);
        user.setSex(SexEnum.WOMAN);
        //调用新增方法
        userDao.insert(user);
    }
}
