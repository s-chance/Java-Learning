package com.entropy.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JsonTest {

    //json转java对象
    @Test
    public void test1() throws IOException {
        //json字符串, 这里的json数据需要与java实体类数据对应
        String json = "{\n\"name\": \"master\",\n\"age\": 23,\n\"gender\": \"男\"}";

        //创建核心对象ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        //json转换java对象
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);
    }

    //java对象转换json
    @Test
    public void test2() throws IOException {
        Person person = new Person();
        person.setName("abc");
        person.setAge(23);
        person.setGender("男");
        person.setTime(new Date());

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);

        objectMapper.writeValue(new File("test.txt"), person);

        objectMapper.writeValue(new FileWriter("io.txt"), person);
    }

    //复杂java对象转换 list集合与map集合转换为json
    @Test
    public void test3() throws JsonProcessingException {
        Person person = new Person();
        person.setName("def");
        person.setAge(33);
        person.setGender("男");
        person.setTime(new Date());

        Person p1 = new Person();
        p1.setName("ghi");
        p1.setAge(27);
        p1.setGender("女");
        p1.setTime(new Date());

        Person p2 = new Person();
        p2.setName("lmn");
        p2.setAge(22);
        p2.setGender("女");
        p2.setTime(new Date());

        List<Person> list = new ArrayList();
        list.add(person);
        list.add(p1);
        list.add(p2);

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonList = objectMapper.writeValueAsString(list);
        System.out.println(jsonList);

        //map的键需与java实体类数据对应
        Map<String, Object> map = new HashMap<>();
        map.put("name", "map");
        map.put("age", "44");
        map.put("gender", "unknown");

        String jsonMap = objectMapper.writeValueAsString(map);
        System.out.println(jsonMap);
    }
}
