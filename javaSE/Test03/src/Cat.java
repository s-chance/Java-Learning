public class Cat extends Pet implements Action,Action2 {

    public Cat(String name, int age,int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void f1() {
        System.out.println("Cat");
    }

    @Override
    public void ff() {

    }

    public void cf(int weight) {
        System.out.println("miao");
        System.out.println(this.weight+weight);
    }

    public Cat() {
    }

    @Override
    public void func1() {
        System.out.println("11");
    }

    @Override
    public void func2() {
        System.out.println("22");
    }

    @Override
    public void func3() {
        System.out.println("33");
    }

    @Override
    public void run() {
        System.out.println("cat running");
    }

    @Override
    public void eat() {
        System.out.println("cat eat fish");
    }

    @Override
    public void play() {
        System.out.println("cat want to play with you");
    }
}
