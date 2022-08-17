package com.entropy.demo;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//模拟用户登录
public class JDBCLogin {

    //这种方式容易受到sql注入

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
            String sql = "select * from user where name = '" + name + "' and password = '" + password + "'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
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
