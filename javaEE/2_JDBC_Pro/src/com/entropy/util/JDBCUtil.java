package com.entropy.util;

import com.mysql.jdbc.Statement;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtil {


    //工具类的构造方法一般都设置为静态属性、私有访问权限,方便直接通过类名调用
    private JDBCUtil() {
    }

    //类加载时绑定属性资源文件
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources/db");

    //注册驱动
    static {
        try {
            Class.forName(bundle.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接对象
    public static Connection getConnection() throws SQLException {
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    //释放资源
    public static void close(Connection connection, PreparedStatement ps, ResultSet resultSet) {
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
