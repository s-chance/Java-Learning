import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefTest {
    //前面出现的::关键字就是lambda表达式中对于方法引用的写法
    //lambda方法引用在下面分为三种情况

    //情况一:对象 :: 实例方法
    //可以看到lambda方法引用 :: 的写法直接忽略了 参数列表 以及 -> 操作符
    @Test
    public void test1() {
        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("你好");

        System.out.println();

        PrintStream out = System.out;
        Consumer<String> consumer2 = out :: println;
        consumer2.accept("hello");
    }
    //这边使用了预先准备的测试数据Employee
    @Test
    public void test2() {
        Employee employee = new Employee(1001, "tom", 23, 6000);
//        Supplier函数内部实现基本代码
//        String s = new Supplier<String>() {
//            @Override
//            public String get() {
//                return employee.getName();
//            }
//        }.get();
//        System.out.println(s);

        Supplier<String> supplier1 = () -> employee.getName();
        System.out.println(supplier1.get());

        System.out.println();

        Supplier<String> supplier2 = employee :: getName;
        System.out.println(supplier2.get());
    }
    //情况二:类 :: 静态方法
    //几乎只需要提供对应的名称即可,进一步简化代码
    @Test
    public void test3() {
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator1.compare(12, 312));

        System.out.println();

        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(32, 31));
    }
    @Test
    public void test4() {
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(function.apply(11.1));

        System.out.println();

        Function<Double, Long> function1 = aDouble -> Math.round(aDouble);
        System.out.println(function1.apply(12.4));

        System.out.println();

        Function<Double, Long> function2 = Math :: round;
        System.out.println(function2.apply(12.9));
    }
    //情况三:类 :: 实例方法（有难度）
    @Test
    public void test5() {
//        Comparator函数内部实现基本代码
//        Comparator comparator = new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        };
        Comparator<String> comparator1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparator1.compare("abc", "avd"));

        System.out.println();

        Comparator<String> comparator2 = String::compareTo;
        System.out.println(comparator2.compare("abc", "aaa"));
    }
    //BiPredicate相对Predicate支持两个参数
    @Test
    public void test6() {
//        BiPredicate函数内部实现基本代码
//        BiPredicate biPredicate = new BiPredicate() {
//            @Override
//            public boolean test(Object o, Object o2) {
//                return false;
//            }
//        };
        BiPredicate<String, String> predicate1 = (s1, s2) -> s1.equals(s2);
        System.out.println(predicate1.test("abc", "abc"));

        System.out.println();

        BiPredicate<String, String> predicate2 = String::equals;
        System.out.println(predicate2.test("abc", "abd"));
    }
    @Test
    public void test7() {
//        Function函数内部实现基本代码
//        Function function = new Function() {
//            @Override
//            public Object apply(Object o) {
//                return null;
//            }
//        };
        Employee employee = new Employee(1021, "Jerry", 33, 89283);
        Function<Employee, String> function1 = e -> e.getName();
        System.out.println(function1.apply(employee));

        System.out.println();

        Function<Employee, String> function2 = Employee::getName;
        System.out.println(function2.apply(employee));
    }
}
