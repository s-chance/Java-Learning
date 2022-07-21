package test;

public class People {
    public String name;
    protected int age;
    protected String work;

    public void say() {
        System.out.println("father");
    }

    //关于父类中的构造方法，构造方法无法被重写
    //当父类存在无参构造时，实例化子类时，父类中的无参构造方法会自动调用
    public People() {
        System.out.println("NULL Struct");
    }

    public People(String s) {
        System.out.println("ONE Struct");
    }
}
