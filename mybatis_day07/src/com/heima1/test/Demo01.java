package com.heima1.test;

import com.heima1.dao.UserMapper;
import com.heima1.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {

    @Test
    public void test() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("=======mapper:"+mapper);
        List<User> allUsers =  mapper.findAllUsers();
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println(allUsers.get(i));
        }
        MybatisUtils.commitAndClose(sqlSession);


    }

    @Test
    public void testAdd() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(null,"zhangshan","2010-2-3","男",""));
        MybatisUtils.commitAndClose(sqlSession);


    }
    @Test
    public void testAdd2() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser2("lishi","2010-2-3","男","asdjfae");
        MybatisUtils.commitAndClose(sqlSession);


    }
    @Test
    public void testAdd3() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser3(new User(null,"wangwu","2010-2-3","男","asdjfae"));
        MybatisUtils.commitAndClose(sqlSession);

    }

    @Test
    public void testDelete() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(45);
        MybatisUtils.commitAndClose(sqlSession);

    }

    @Test
    public void findUserByKid() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userByKid = mapper.findUserByKid("%王%");
        List<User> userByKid = mapper.findUserByKid("王");
        for (int i = 0; i < userByKid.size(); i++) {
            System.out.println(userByKid.get(i));
        }
        MybatisUtils.commitAndClose(sqlSession);

    }

    //主键回调，主键能返回给user JavaBean
    @Test
    public void addReturnid() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //User user = new User(null,"zhaoliu","1994-4-2","男","日本");
        User user = new User(null,"zhouzheng","1994-4-2","男","日本");
        mapper.insertReturnId(user);
        System.out.println(user);
        MybatisUtils.commitAndClose(sqlSession);

    }

    //动态sql
    @Test
    public void dynamicSql() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String name = "王小二";
        //String sex = "男";
        List<User> users = mapper.dynamicSql(name, null);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));

        }
        MybatisUtils.commitAndClose(sqlSession);

    }
    //动态sql update
    @Test
    public void updateDynamicSql() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String name = "王小二";
        User user = new User(50,"hehe","2021-9-3","女","guangzhou");

        int n = mapper.updateDynamicSql(user);
        System.out.println("被影响的行数："+n);
        MybatisUtils.commitAndClose(sqlSession);

    }

    //动态sql foreach
    @Test
    public void findByIdsSql() throws Exception {
        SqlSession sqlSession = MybatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,50,51,52);
        List<User> users = mapper.findByIdsSql(arrayList);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
        MybatisUtils.commitAndClose(sqlSession);

    }
}
