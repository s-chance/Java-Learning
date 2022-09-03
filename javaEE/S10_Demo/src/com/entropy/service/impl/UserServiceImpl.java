package com.entropy.service.impl;

import com.entropy.dao.UserDao;
import com.entropy.dao.impl.UserDaoImpl;
import com.entropy.pojo.Page;
import com.entropy.pojo.User;
import com.entropy.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    //查询所有用户信息
    @Override
    public List<User> searchAll() {
        return userDao.searchAll();
    }

    //查询登录用户
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    //新增用户
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    //根据id删除用户
    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    //根据id查询用户
    @Override
    public User searchById(String id) {
        return userDao.searchById(id);
    }

    //修改用户数据
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    //批量删除
    @Override
    public void deleteSelected(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                userDao.deleteById(id);
            }
        }
    }

    //分页查询
    @Override
    public Page<User> searchByPage(String pageNow, String pageSize, Map<String, String[]> map) {
        int now = Integer.parseInt(pageNow);
        int size = Integer.parseInt(pageSize);

        //创建Page对象
        Page<User> page = new Page<>();

        //设置基本参数
        page.setPageSize(size);

        //调用dao查询记录总数
        int count = userDao.count(map);
        page.setCount(count);

        //计算总页数:根据记录总数能否被每页记录数整除,不能整除则说明还有剩余的记录组成一页
        int total = count%size == 0?count/size:(count/size)+1;

        //考虑记录数为零的情况,设置总页数至少存在一页
        if (total == 0) {
            total = 1;
        }

        //考虑分页逻辑当前页可能出现小于等于零的情况,重新设置值
        if (now <= 0) {
            now = 1;
        }

        //考虑分页逻辑当前页可能出现大于总页数的情况,重新设置值
        if (now > total) {
            now = total;
        }

        page.setPageNow(now);
        page.setPageTotal(total);


        //调用dao查询每页的数据集合
        //计算起始的索引
        int startIndex = (now - 1) * size;
        List<User> list = userDao.searchByPage(startIndex, size, map);
        page.setPageList(list);

        return page;
    }
}
