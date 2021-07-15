package com.heima.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
JDBC 入门案例
1，不关注实现，必须要有实现
2，导入驱动
 */
public class Demo03_transaction {
    public static void main(String[] args) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入转出的账户");
            String name1 = scanner.nextLine();
            System.out.println("请输入转入的账户");
            String name2 = scanner.nextLine();
            System.out.println("请输入转出的金额");
            String money = scanner.nextLine();
            //String sql1 = "UPDATE account SET money = money -  " + money + " WHERE NAME = '" + name1 + "'";
            String sql = "CALL pro_transfer1('"+ name1 +"','"+ name2+"',"+money+ ")";
            statement.executeQuery(sql);
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,statement,connection);
        }


    }

}
