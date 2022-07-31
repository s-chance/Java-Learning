package stream;

import data.Employee;
import data.EmployeeDate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2 {
    //注意不能对已经创建好的stream流再进行操作
    //java.lang.IllegalStateException: stream has already been operated upon or closed

    //另外stream流在未转换之前只能通过forEach来遍历

    //stream流的中间操作
    //筛选与切片
    @Test
    public void test1() {
        //filter排除
        //排除掉salary 小于等于 6000 的employee
        List<Employee> employees = EmployeeDate.getEmployees();
        Stream<Employee> filter = employees.stream().filter(e -> e.getSalary() > 6000);
        filter.forEach(System.out::println);
        System.out.println();
        //limit截断
        //截断,只输出前面2条数据
        employees.stream().limit(2).forEach(System.out::println);
        System.out.println();
        //skip跳过
        //跳过前面两条数据,如果跳过的数据大于总数则为空
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println();
        //distinct去重
        Employee e1 = new Employee(1, "lun", 11, 3555);
        Employee e2 = new Employee(1, "lun", 11, 3555);
        Employee e3 = new Employee(1, "lun", 11, 3555);
        Employee e4 = new Employee(1, "lun", 11, 3555);
        ArrayList<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2() {
        //map对流中的每个元素进行转换
        List<String> stringList = Arrays.asList("a", "b", "c", "d");
        //将所有小写字母转为大写字母
        stringList.stream().map(s -> s.toUpperCase()).forEach(System.out::print);
        System.out.println();
        //输出大于6000的salary
        List<Employee> employees = EmployeeDate.getEmployees();
        employees.stream().map(e -> e.getSalary()).filter(salary -> salary > 6000).forEach(System.out::println);
        System.out.println();

        //这边再对map和flatMap进行对比
        //可以看到flatMap已经将原来的元素合成了一个新的流,而map仍保留了每个流
        //map要实现与flatMap一样的效果,需要对内部的流以及外部的流进行两次forEach操作,而flatMap只需一次
        //map通常用于简单的转换,而flatMap则用于比较复杂的转换
        Stream<Stream<Character>> streamStream = stringList.stream().map(StreamTest2::characterStream);
        streamStream.forEach(characterStream -> characterStream.forEach(System.out::print));
        System.out.println();
        //flatMap对流中每个元素进行平铺后,形成多个流合在一起
        Stream<Character> stream = stringList.stream().flatMap(StreamTest2::characterStream);
        stream.forEach(System.out::print);
        System.out.println();
    }

    //获取String转换为Character的Stream流
    public static Stream<Character> characterStream(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character character : s.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    //排序
    @Test
    public void test3() {
        //sorted无参 自然排序  对引用数据类型需要先实现Comparable接口,这边为了方便就用基本数据类型演示
        List<Integer> integers = Arrays.asList(1, 13, -23, 0, 29, 65, -19);
        //默认升序
        integers.stream().sorted().forEach(System.out::println);

        //sorted+Comparator 定义排序  根据age升序排序,age相同则根据salary升序排序
        List<Employee> employees = EmployeeDate.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            int age = Integer.compare(e1.getAge(), e2.getAge());
            return age!=0?age:Double.compare(e1.getSalary(), e2.getSalary());
        }).forEach(System.out::println);
    }
}
