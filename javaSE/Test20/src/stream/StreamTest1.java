package stream;

import data.Employee;
import data.EmployeeDate;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {
    //先准备一下测试数据
    //stream流实例化的方式
    @Test
    public void test1() {
        //通过集合
        List<Employee> employees = EmployeeDate.getEmployees();
        Stream<Employee> stream = employees.stream();
        //通过数组
        Employee e1 = new Employee(1, "sal", 12, 1000);
        Employee e2 = new Employee(2, "lam", 24, 3544);
        Employee[] es = new Employee[] {e1, e2};
        Stream<Employee> employeeStream = Arrays.stream(es);
        //通过Stream的of()方法
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        //创建无限流
        //注意无限流需要用limit方法限制,否则会无限执行下去
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(1).forEach(System.out::println);
    }
}
