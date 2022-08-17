package com.entropy.test;

import org.junit.Test;

import java.sql.*;

public class JDBCTest {
    //PreparedStatement实现增删改
    @Test
    public void test1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task?serverTimezone=GMT", "root", "root");
            //3.获取预处理数据库操作对象

            /*
            //新增操作
            String sql = "insert into user(name,password) values (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"jerry");
            preparedStatement.setString(2,"456");
            */
            /*
            //修改操作
            String sql = "update user set password=? where name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"789");
            preparedStatement.setString(2,"jerry");
             */

            //删除操作
            String sql = "delete from user where name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"jerry");

            //4.执行sql
            System.out.println(sql);
            int count = preparedStatement.executeUpdate();
            System.out.println("rows:"+count);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            //5.释放资源
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
    //PreparedStatement实现模糊查询
    @Test
    public void test2() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task?serverTimezone=GMT", "root", "root");
            //3.获取预处理的数据库操作对象
            String sql = "select name from user where name like ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"%t%");
            //4.执行sql
            resultSet = ps.executeQuery();
            //5.处理查询结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
