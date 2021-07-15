package com.heima.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
JDBC 入门案例
1，不关注实现，必须要有实现
2，导入驱动
 */
public class Demo05_prepareStatement {
    public static void main(String[] args) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入账户");
            String name1 = scanner.nextLine();
            System.out.println("请输入密码");
            String password = scanner.nextLine();

            String sql = "SELECT * FROM `user` WHERE NAME = ? AND pw = ?";
            /*
            sql 注入 （bug）
            以拼接的形式，用户将含有语法的字符串拼接进原sql ，达到串改sql 的目的
            SELECT * FROM `user` WHERE NAME = 'jack -- AND pw = 123456;
            如果我输入jack' -- 就会不需要密码
             */
            //解决注入问题  -- 预编译, 会把 name password 都加上转义符，所有语法字符视为普通字符
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name1);
            preparedStatement.setString(2,password);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            if (resultSet1.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {

            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,statement,connection);
        }


    }

}
