package com.heima.utils;

import org.junit.Test;

import java.sql.*;

/*
JDBC 入门案例
1，不关注实现，必须要有实现
2，导入驱动
 */
public class Demo01_statement {
    @Test
    public void test1()  {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from dept";

            resultSet = statement.executeQuery(sql);
            //4,处理结果
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("id:"+id + ","+ "name:"+ name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,statement,connection);
        }


    }


}
