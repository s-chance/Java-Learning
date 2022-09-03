package com.entropy.dao;

import com.entropy.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //查询所有用户信息
    public List<User> searchAll();

    //查询登录用户
    User login(User user);

    //新增用户
    void addUser(User user);

    //根据id删除用户
    void deleteById(String id);

    //根据id查询用户
    User searchById(String id);

    //修改用户数据
    void update(User user);

    //查询记录总数
    int count(Map<String, String[]> map);

    //查询每页的数据集合
    List<User> searchByPage(int startIndex, int size, Map<String, String[]> map);
}
