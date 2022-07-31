public class Cat extends Pet {

    public Cat(String name, int age,int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void f1() {
        System.out.println("Cat");
    }

    public void cf(int weight) {
        System.out.println("miao");
        System.out.println(this.weight+weight);
    }

    public Cat() {
    }
}
