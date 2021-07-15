package com.heima.entity;

import com.heima.utils.JDBCUtils;
import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

/*
JDBC 入门案例
1，不关注实现，必须要有实现
2，导入驱动
 */
public class Demo06_prepareStatement {
    //DML
    @Test
    public  void  testPrepareStatement() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "DELETE FROM `user` WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        long l = preparedStatement.executeLargeUpdate();
        System.out.println("被影响的行数：" + l);
        JDBCUtils.release(null,preparedStatement,connection);
    }

    /**DQL 查询语句
     * ORM 对象映射关系（object relasitionship mapping）
     * 含义：数据表中的每一条数据都映射成 java 中的一个对象
     * 标准：要有对象，必先有类，即实体类（javaBean）
     * 必须有
     * 1，public 空参构造
     * 2，private 属性
     * 3，public get/set 方法
     * 4，实现 serialiable 序列化接口
     * 这4条规范缺一不可
     * @throws Exception
     */
    @Test
    public  void  testDQL() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * FROM `user`";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("pw"));
            System.out.println(user);
        }
        JDBCUtils.release(resultSet,preparedStatement,connection);
    }

}
