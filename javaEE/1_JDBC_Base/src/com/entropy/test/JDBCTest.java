package com.entropy.test;

import org.junit.Test;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest {

    //原生代码实现
    @Test
    public void test1() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1.注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task?serverTimezone=GMT", "root", "root");
            //3.获取数据库操作对象
            statement = connection.createStatement();
            //4.执行sql语句
            String sql = "select name from coder";
            resultSet = statement.executeQuery(sql);
            //5.处理查询结果集
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
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
            if (statement != null) {
                try {
                    statement.close();
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

    //类加载反射实现
    @Test
    public void test2() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task?serverTimezone=GMT", "root", "root");
            //3.获取数据库操作对象
            statement = connection.createStatement();
            //4.执行sql语句
            String sql = "select name from coder";
            resultSet = statement.executeQuery(sql);
            //5.处理查询结果集
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
            if (statement != null) {
                try {
                    statement.close();
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

    //配置文件实现
    @Test
    public void test3() {
        //资源绑定器
        ResourceBundle bundle = ResourceBundle.getBundle("resources/db");
        //通过配置文件获取信息
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1.注册驱动
            Class.forName(driver);
            //2.获取连接
            connection = DriverManager.getConnection(url, user, password);
            //3.获取数据库操作对象
            statement = connection.createStatement();
            //4.执行sql语句
            String sql = "select name from coder";
            resultSet = statement.executeQuery(sql);
            //5.处理查询结果集
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
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
