public abstract class Pet {
    String name;
    int age;
    int weight;


    //abstract需要在抽象类中使用，将类声明为抽象类，抽象方法中不能有方法体，因此省略了代码
    public abstract void f1();


    //抽象方法在非抽象子类中必须重写
    public abstract void ff();


    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pet() {
    }
}
