import entity.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1() {
        //创建Person对象
        Person tom = new Person("Tom", 12);
        //通过对象调用其内部的属性方法
        tom.age = 10;
        System.out.println(tom.toString());

        tom.show();
        //在Person类外部,不能通过Person类的对象调用内部私有结构
        //但是通过反射的机制就能够突破private权限进行访问,然而实际开发中反射并不常用,
        //只是了解反射有助于对java底层的理解
    }

    //使用反射
    @Test
    public void test2() throws Exception {
        //通过反射创建Person类对象
        Class personClass = Person.class;
        //调用构造器getConstructor   使用newInstance方法获取Object对象
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 12);
        //强转Object对象为Person对象
        Person tom1 = (Person) tom;
        System.out.println(tom1.toString());

        //通过反射的getDeclaredField方法调用对象指定的属性  方法
        Field age = personClass.getDeclaredField("age");
        age.set(tom1, 10);
        System.out.println(tom1.toString());
        //调用方法invoke
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(tom1);

        System.out.println();

        //通过反射调用Person类的私有结构
        //调用私有的构造器getDeclaredConstructor,私有构造器的参数对应私有构造的参数的类
        Constructor declaredConstructor = personClass.getDeclaredConstructor(String.class);
        //进行私有构造的操作时需要执行setAccessible方法,关闭安全检测
        declaredConstructor.setAccessible(true);
        Person jerry = (Person) declaredConstructor.newInstance("Jerry");
        System.out.println(jerry);
        //调用私有属性getDeclaredField
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerry, "cat");
        System.out.println(jerry);
        //调用私有方法getDeclaredMethod
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //invoke:调用
        Object invoke = showNation.invoke(jerry, "China");
        System.out.println(invoke);

        //反射具有动态性
    }
}
