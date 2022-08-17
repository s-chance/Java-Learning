package com.entropy.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?serverTimezone=GMT", "root", "root");

            //开启事务,关闭自动提交机制
            connection.setAutoCommit(false);

            //3.获取预处理的数据库操作对象
            String sql = "update account set money=? where id=?";
            ps = connection.prepareStatement(sql);
            ps.setDouble(1,7800);
            ps.setInt(2,1);
            //4.执行sql
            int count = ps.executeUpdate();

            //模拟异常情况
            //在没有开启事务的情况下,后面的sql就不会执行,对数据造成影响
            String s = null;
//            s.toString();


            ps.setDouble(1,3100);
            ps.setInt(2,2);
            //4.执行sql
            count += ps.executeUpdate();
            System.out.println("rows:"+count);
            System.out.println(count==2?"success":"fail");


//            s.toString();

            //手动提交事务,执行到这里时就默认事务已经全部正确地执行
            //提交事务之后无法再回滚
            connection.commit();

        } catch (Exception e) {
            //出现异常,事务回滚
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            //5.释放资源
            if(ps != null) {
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
