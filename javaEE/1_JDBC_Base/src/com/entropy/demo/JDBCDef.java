package com.entropy.demo;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//模拟用户登录,加强对sql注入的防卫
public class JDBCDef {

    //加强对sql注入的访卫,关键是对sql语句的拼接处理

    public static void main(String[] args) {
        //初始化  登录
        Map<String, String> init = init();
        //连接数据库验证
        boolean check = check(init.get("name"), init.get("password"));
        System.out.println(check?"success":"fail");
    }

    //验证
    private static boolean check(String name, String password) {
        boolean result = false;

        Connection connection = null;
        //Statement替换为PreparedStatement
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task?serverTimezone=GMT", "root", "root");

            //3.获取数据库操作对象,这边在获取对象之前预处理了sql语句
            //?表示一个占位符,一个占位符对应一个值
            String sql = "select * from user where name = ? and password = ?";
            //预处理sql语句
            statement = connection.prepareStatement(sql);
            //给占位符传值
            //传值在JDBC中从下标1开始
            statement.setString(1, name);
            statement.setString(2, password);

            //4.执行sql语句
            System.out.println(sql);
            resultSet = statement.executeQuery();

            //5.处理查询结果集
            if(resultSet.next()) {
                result = true;
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
        return result;
    }

    //初始化
    public static Map<String, String> init() {
        System.out.println("login,please input name and password:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("name:");
        String name = scanner.next();
        System.out.println("password:");
        String password = scanner.next();
        //name和password存放到map中
        Map<String, String> info = new HashMap<>();
        info.put("name", name);
        info.put("password", password);
        return info;
    }
}
