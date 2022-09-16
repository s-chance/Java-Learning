package com.entropy.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    @Test
    public void test1() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);

        //操作
        jedis.set("name", "en");

        //关闭连接
        jedis.close();
    }

    //jedis操作string数据结构
    @Test
    public void test2() {
        Jedis jedis = new Jedis(); //无参构造, 默认"localhost" 6379

        //存储
        jedis.set("name", "tom");

        //获取
        String name = jedis.get("name");
        System.out.println(name);

        //setex()方法指定过期时间自动删除数据
        //设置20秒后自动删除live-time键
        jedis.setex("live-time", 20, "20 seconds");

        jedis.close();
    }

    //jedis操作hash数据结构
    @Test
    public void test3() {
        Jedis jedis = new Jedis();

        //存储
        jedis.hset("user", "name", "jerry");
        jedis.hset("user", "age", "12");
        jedis.hset("user", "password", "jerry123");

        //获取指定数据
        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取所有数据
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            String value = user.get(key);
            System.out.println(key + ": " + value);
        }

        jedis.close();
    }

    //jedis操作list数据结构
    @Test
    public void test4() {
        Jedis jedis = new Jedis();

        //压栈
        jedis.lpush("list", "a", "b", "c");
        jedis.rpush("list", "a", "b", "c");

        //范围获取
        List<String> list = jedis.lrange("list", 0, -1);
        System.out.println(list);

        //出栈
        String lpop = jedis.lpop("list");
        System.out.println(lpop);
        String rpop = jedis.rpop("list");
        System.out.println(rpop);

        List<String> lrange = jedis.lrange("list", 0, -1);
        System.out.println(lrange);

        jedis.close();
    }

    //jedis操作set数据结构
    @Test
    public void test5() {
        Jedis jedis = new Jedis();

        //存储
        jedis.sadd("set", "java", "c", "c++");

        //获取
        Set<String> set = jedis.smembers("set");
        System.out.println(set);

        jedis.close();
    }

    //jedis操作sorted set数据结构
    @Test
    public void test6() {
        Jedis jedis = new Jedis();

        //存储
        jedis.zadd("sorted", 2, "lun");
        jedis.zadd("sorted", 4, "dum");
        jedis.zadd("sorted", 1, "debian");
        jedis.zadd("sorted", 3, "arch");

        //获取
        Set<String> sorted = jedis.zrange("sorted", 0, -1);
        System.out.println(sorted);

        jedis.close();
    }
}
