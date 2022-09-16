package com.entropy.service;

import com.entropy.pojo.Province;

import java.util.List;

public interface ProvinceService {

    //查询所有信息
    List<Province> searchAll();

    //redis缓存查询
    String searchAllByRedis();
}
