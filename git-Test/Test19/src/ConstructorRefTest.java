import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest {
    //构造器引用

    //无参构造  Supplier支持无参
    @Test
    public void test1() {
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(supplier.get());

        System.out.println();

        Supplier<Employee> supplier1 = () -> new Employee();
        System.out.println(supplier1.get());

        System.out.println();

        Supplier<Employee> supplier2 = Employee::new;
        System.out.println(supplier2.get());
    }
    //有参构造 Function支持一个参数
    @Test
    public void test2() {
        Function<Integer, Employee> function = id -> new Employee(id);
        Employee employee = function.apply(1001);
        System.out.println(employee);

        System.out.println();

        Function<Integer, Employee> function1 = Employee::new;
        System.out.println(function1.apply(1002));
    }
    //BiFunction支持两个参数
    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> biFunction = (id, name) -> new Employee(id, name);
        System.out.println(biFunction.apply(1001, "tom"));

        System.out.println();

        BiFunction<Integer, String, Employee> biFunction1 = Employee::new;
        System.out.println(biFunction1.apply(1002, "Jerry"));
    }
    //数组引用,其实和构造器引用差不多
    @Test
    public void test4() {
        //传入Integer类型的数据指定String[]的长度
        Function<Integer, String[]> function = length -> new String[length];
        //调用apply方法返回一个指定长度的String[]
        String[] apply = function.apply(9);
        System.out.println(Arrays.toString(apply));

        System.out.println();

        Function<Integer, String[]> function1 = String[]::new;
        String[] apply1 = function1.apply(4);
        System.out.println(Arrays.toString(apply1));
    }
}
