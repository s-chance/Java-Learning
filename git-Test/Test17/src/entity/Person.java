package entity;

public class Person {
    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

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

    @Override
    public String toString() {
        return "entity.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //私有构造器
    private Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("你好");
    }

    private String showNation(String nation) {
        System.out.println(nation);
        return nation;
    }
}
