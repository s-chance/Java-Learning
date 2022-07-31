package data;

import java.util.ArrayList;
import java.util.List;

//提供用于测试的数据
public class EmployeeDate {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"小米",34,6000.38));
        list.add(new Employee(1002,"小强",12,9876.12));
        list.add(new Employee(1003,"鲁本",34,3000.82));
        list.add(new Employee(1004,"海伦",26,7657.37));
        list.add(new Employee(1005,"比尔",65,5555.32));
        list.add(new Employee(1006,"夏目",42,9500.43));
        list.add(new Employee(1007,"蒂尼",24,4333.32));
        list.add(new Employee(1008,"克莱",35,2500.32));
        return list;
    }
}