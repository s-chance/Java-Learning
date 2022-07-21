import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest2 {
    //这里简单展示了六种lambda表达式的语法格式

    //语法格式一:无参,无返回值
    @Test
    public void test1() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        runnable1.run();

        System.out.println("普通写法转lambda");

        Runnable runnable2 = () -> {
            System.out.println("java");
        };
        runnable2.run();
    }
    //语法格式二:一个参数,无返回值
    @Test
    public void test2() {
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("git");

        System.out.println("普通写法转lambda");

        Consumer<String> consumer2 = (String s) -> {
            System.out.println(s);
        };
        consumer2.accept("jdk");
    }
    //语法格式三:"类型推断",数据类型可由编译器推断,即参数的数据类型不强制需要指明,编译器会帮助你处理好
    @Test
    public void test3() {
        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("jdk");

        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };
        consumer2.accept("jdk");

        //类型推断例子  泛型和数组
        ArrayList<String> list = new ArrayList<>();
        int[] arr = {1, 2, 3};
    }
    //语法格式四:一个参数可省略括号,无参和多参都不能省略括号
    @Test
    public void test4() {
        Consumer<String> consumer1 = s -> {
            System.out.println(s);
        };
        consumer1.accept("jdk");
    }
    //语法格式五:两个及以上的参数,多条执行语句,可能存在返回值
    @Test
    public void test5() {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //多条执行语句
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator1.compare(1,2));

        System.out.println();

        Comparator<Integer> comparator2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(comparator2.compare(121, 21));
    }
    //语法格式六:只有一条语句时,return与大括号{}可省略,但是有多条语句时大括号{}与return就不能省略
    @Test
    public void test6() {
        Comparator<Integer> comparator1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(12, 4234));

        System.out.println();

        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparator2.compare(12,6756));
    }
}
