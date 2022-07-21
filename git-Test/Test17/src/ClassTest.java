import entity.Person;
import org.junit.Test;

public class ClassTest {
    //java.lang.Class类

    //这边简单了解一下Class对象

    //获取Class实例的方式
    //以下Class实例的地址值都是一样的
    @Test
    public void test1() throws ClassNotFoundException {
        //方式一:调用运行时类的属性 .class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //方式二:通过运行时类的对象,调用getClass
        Person person = new Person();
        Class aClass = person.getClass();
        System.out.println(aClass);
        //方式三:调用Class的静态方法:forName(String classPath)
        Class person1 = Class.forName("entity.Person");
        System.out.println(person1);

        System.out.println(personClass == aClass);
        System.out.println(personClass == person1);

        //方式四:使用类的加载器ClassLoader
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        Class person2 = classLoader.loadClass("entity.Person");
        System.out.println(person2);
        System.out.println(personClass == person2);
    }

    //Class实例的结构说明
    //这边简单列举了一些Class实例
    //对象、接口、数组、void、Class本身包括注解也能用于Class实例化
    @Test
    public void test2() {
        Class objectClass = Object.class;
        Class comparableClass = Comparable.class;
        Class stringClass = String[].class;
        Class intClass = int[].class;
        Class<Void> voidClass = void.class;
        Class<Class> classClass = Class.class;
        Class<Override> overrideClass = Override.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class aClass = a.getClass();
        Class bClass = b.getClass();
        //只要数组的元素类型与维度一样就是同一个Class,与数组的容量无关
        //数组的维度就是指一维数组、二维数组等
        int[][] c = new int[10][];
        int[][] d = new int[100][];
        double[] doubles = new double[10];
        Class cClass = c.getClass();
        Class dClass = d.getClass();
        Class doublesClass = doubles.getClass();
        System.out.println(aClass == bClass);
        System.out.println(aClass == cClass);
        System.out.println(cClass == dClass);
        System.out.println(aClass == doublesClass);
    }
}
