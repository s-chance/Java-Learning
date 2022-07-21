package test;

import test.People;

public class Student extends People {

    //static静态修饰符
    public static int id;

    public static int getId(int ids) {
        id = ids;                        //静态属性也无法用this来修改
        System.out.println(id); //静态方法只能用本类中的静态属性
        return id;
    }

    //封装的使用   首先设置对象的属性访问权限均为private,限制对属性进行直接修改

    //然后编写getter和setter方法 getter获取属性  setter设置属性

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if(age <= 0) {
            System.out.println("非法值");
            this.age = 404;
        }
        else {
            this.age = age;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("study");
    }

    public Student() {
        //这里隐藏了super();由java自动产生
        //super();//super()即调用父类与this()类似
        super("ff");//通过super()加参数便可调用父类有参构造，默认一般是调用无参构造
        System.out.println("struct for student");
    }

    public void f(People p) {
        p.name="kk";
        p.age=11;
    }
}
