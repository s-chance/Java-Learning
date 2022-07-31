import entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        //动态创建对象执行方法

        //传入指定的classPath就能动态创建对象

        //获取Class对象
        Class person = Class.forName("entity.Person");
        //构造对象,本质是调用无参构造
        Person p = (Person) person.newInstance();
        System.out.println(p);
        //通过构造器创建对象
        Constructor declaredConstructor = person.getDeclaredConstructor(String.class, int.class);
        Person xiaomi = (Person) declaredConstructor.newInstance("xiaomi", 18);
        System.out.println(xiaomi);

        //通过反射调用普通方法
        Person person1 = (Person) person.newInstance();
        //通过反射获取一个方法
        Method setName = person.getDeclaredMethod("setName", String.class);
        //invoke激活
        setName.invoke(person1, "lube");
        System.out.println(person1.getName());

        System.out.println();

        //通过反射操作属性
        Person person2 = (Person) person.newInstance();
        Field name = person.getDeclaredField("name");
        //不能直接操作私有属性,需要关闭程序的安全检测
        name.setAccessible(true);
        name.set(person2, "Ming");
        System.out.println(person2.getName());
    }
}
