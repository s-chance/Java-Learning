package com.entropy.dao.impl;

import com.entropy.dao.UserDao;
import com.entropy.pojo.User;
import com.entropy.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    //创建JdbcTemplate对象,所有的数据的增删改查操作就通过JdbcTemplate实现
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

    //查询所有用户信息
    @Override
    public List<User> searchAll() {

        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return userList;

    }

    //查询登录用户
    @Override
    public User login(User user) {

        String sql = "select * from user where username = ? and password = ?";
        User login = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        return login;
    }

    //新增用户
    @Override
    public void addUser(User user) {
        String sql = "insert into user values (null,?,?,?,?,?,?,null,null)";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail());
    }

    //根据id删除用户
    @Override
    public void deleteById(String id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
    }

    //根据id查询用户
    @Override
    public User searchById(String id) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    //修改用户数据
    @Override
    public void update(User user) {
        String sql = "update user set name=?,gender=?,age=?," +
                "address=?,qq=?,email=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    //查询记录总数
    @Override
    public int count(Map<String, String[]> map) {
        //where 1 = 1是为了方便后面拼接条件语句
        String sql = "select count(*) from user where 1 = 1";
        StringBuilder builder = new StringBuilder(sql);
        //这里获取前端传来的所有条件参数的名字
        Set<String> strings = map.keySet();

        //这里用于存放条件参数对应的值,并赋值给sql中对应的占位符
        ArrayList<Object> objects = new ArrayList<>();

        for (String string : strings) {
            //排除不需要参与sql语句的参数
            if ("pageNow".equals(string) || "pageSize".equals(string)) {
                continue;
            }
            //map返回的是数组,这里直接获取第一个元素即可
            String value = map.get(string)[0];
            if (value != null && !"".equals(value)) {
                //这里对sql进行了预处理,所以不用担心字符串拼接的sql注入
                builder.append(" and "+string+" like ? ");
                objects.add("%"+value+"%");
            }
        }
        return jdbcTemplate.queryForObject(builder.toString(), Integer.class, objects.toArray());
    }

    //查询每页的数据集合
    @Override
    public List<User> searchByPage(int startIndex, int size, Map<String, String[]> map) {
        String sql = "select * from user where 1 = 1";
        StringBuilder builder = new StringBuilder(sql);
        Set<String> strings = map.keySet();
        ArrayList<Object> objects = new ArrayList<>();
        for (String string : strings) {
            if ("pageNow".equals(string) || "pageSize".equals(string)) {
                continue;
            }

            String value = map.get(string)[0];
            if (value != null && !"".equals(value)) {
                builder.append(" and "+string+" like ? ");
                objects.add("%"+value+"%");
            }
        }
        //拼接分页限制条件
        builder.append(" limit ?,? ");
        objects.add(startIndex);
        objects.add(size);
        return jdbcTemplate.query(builder.toString(), new BeanPropertyRowMapper<User>(User.class), objects.toArray());
    }
}
