package stream;

import data.Employee;
import data.EmployeeDate;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest3 {
    //stream流的终止操作
    //匹配与查找
    @Test
    public void test1() {
        //allMatch 检查是否所有元素满足条件
        //检查是否所有人age大于18
        List<Employee> employees = EmployeeDate.getEmployees();
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);
        //anyMatch 检查是否至少存在一个元素满足条件
        //检查是否有人salary大于10000
//        employees.add(new Employee(0000, "god", 1000, 110000));
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);
        //noneMatch 检查是否没有元素满足条件
        //检查是否没有人age超过100
        boolean noneMatch = employees.stream().noneMatch(e -> e.getAge() > 100);
        System.out.println(noneMatch);
        //findFirst 查找第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        //count 统计流中的元素总个数
        long count = employees.stream().count();
        System.out.println(count);
        //max 查找流中最大值
        Optional<Double> max = employees.stream().map(e -> e.getSalary()).max(Double::compare);
        System.out.println(max);
        //min 查找流中最小值
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        //forEach 内部遍历
    }
    //归约
    @Test
    public void test2() {
        //reduce+两个参数 将流中元素反复结合起来,得到一个指定类型的值
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = integers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        //reduce+一个参数 将流中元素反复结合起来,得到一个Optional类型的值
        List<Employee> employees = EmployeeDate.getEmployees();
        Optional<Double> reduce = employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
        System.out.println(reduce);
        Optional<Double> reduce1 = employees.stream().map(e -> e.getSalary()).reduce((s1, s2) -> s1 + s2);
        System.out.println(reduce1);
    }

    //收集
    @Test
    public void test3() {
        //collect 将流转换为其他形式,通过实现Collector接口,对流中的元素进行汇总

        //转为list集合
        List<Employee> employees = EmployeeDate.getEmployees();
        List<Employee> list = employees.stream().collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println();
        //转为set集合
        Set<Employee> set = employees.stream().collect(Collectors.toSet());
        set.forEach(System.out::println);
    }
}
