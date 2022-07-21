public class Dog extends Pet {

    public Dog(String name, int age,int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void f1() {
        System.out.println("Dog");
    }

    @Override
    public void ff() {

    }

    //Alt+Enter快捷键实现方法

    public void df(int weight) {
        System.out.println("hungry");
        System.out.println(this.weight+weight);
    }

    public Dog() {
    }
}
