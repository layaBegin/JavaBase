package com.heima.day05_jdbc;

import org.junit.Test;

import java.sql.*;

/*
JDBC 入门案例
1，不关注实现，必须要有实现
2，导入驱动
 */
public class Demo03_statement {
    @Test
    public void test1() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day02_3";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        /*
        1,bollen result = statement.execute(sql);
         a)sql 可以是任意的 语句，但最好是DDL（data definate language） （create，alter，drop...）
         b)返回值是true 表示是一个查询语句，有结果集
         c）返回值是false 则不是一个查询语句，没有结果集
        2，ResultSet resultSet = statement.executeQuery(sql);
            a)sql 适合 DQL （查询语句）select
            b）返回值是结果集
        3，int count = statement.excuteUpdate(sql);
            a)sql 适合 DML （update，delete，insert）
            b）返回值是被影响的行数
         */
        String sql = "select * from dept";

        ResultSet resultSet = statement.executeQuery(sql);
        //4,处理结果
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id:"+id + ","+ "name:"+ name);
        }
        //5，释放连接
        resultSet.close();
        statement.close();
        connection.close();

    }

    @Test
    public void test0() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day02_3";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        /*
        1,bollen result = statement.execute(sql);
         a)sql 可以是任意的 语句，但最好是DDL（data definate language） （create，alter，drop...）
         b)返回值是true 表示是一个查询语句，有结果集
         c）返回值是false 则不是一个查询语句，没有结果集
        2，ResultSet resultSet = statement.executeQuery(sql);
            a)sql 适合 DQL （查询语句）select
            b）返回值是结果集
        3，int count = statement.excuteUpdate(sql);
            a)sql 适合 DML （update，delete，insert）
            b）返回值是被影响的行数
         */
        String sql = "create table testDDL(id int, name varchar(20),nowDate date)";
        boolean execute = statement.execute(sql);
        System.out.println(execute);
        statement.close();
        connection.close();

    }

    @Test
    public void test2() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day02_3";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        /*
        1,bollen result = statement.execute(sql);
         a)sql 可以是任意的 语句，但最好是DDL（data definate language） （create，alter，drop...）
         b)返回值是true 表示是一个查询语句，有结果集
         c）返回值是false 则不是一个查询语句，没有结果集
        2，ResultSet resultSet = statement.executeQuery(sql);
            a)sql 适合 DQL （查询语句）select
            b）返回值是结果集
        3，int count = statement.excuteUpdate(sql);
            a)sql 适合 DML （update，delete，insert）
            b）返回值是被影响的行数
         */
        //String sql = "insert into emp values(null,'周芷若','女',1000,2020-01-01,2)";
        String sql = "insert into dept values(5,'神马部')";
        int count = statement.executeUpdate(sql);
        System.out.println(count);
        statement.close();
        connection.close();

    }
}
