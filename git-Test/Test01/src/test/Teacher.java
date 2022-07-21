package test;

public class Teacher extends People {


    //Alt+Insert快捷键快速生成getter和setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void say() {
        System.out.println("teach"); //子类中可以重写父类的同名方法，区别于方法重载。
    }
}
