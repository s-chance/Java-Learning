package com.entropy.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private Integer age;
    private Date birthday;

    //由于jsp的规范,要在jsp页面使用EL表达式获取方法的返回值时,方法必须以get+大写字母的格式命名
    public String getFormatTime() {
        //格式化日期
        if (birthday != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(birthday);
            return format;
        } else {
            return "";
        }
    }

    public User(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
