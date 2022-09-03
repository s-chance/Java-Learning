package com.entropy.service;

import com.entropy.pojo.Page;
import com.entropy.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
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

    //批量删除
    void deleteSelected(String[] ids);

    //分页查询
    Page<User> searchByPage(String pageNow, String pageSize, Map<String, String[]> map);
}
