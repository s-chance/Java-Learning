import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodTest {
    //反射获取类的运行时结构

    @Test
    public void test() throws Exception {
        Class person = Class.forName("entity.Person");
        //获取类的名字
        //包名+类名getName
        System.out.println(person.getName());
        //类名getSimpleName
        System.out.println(person.getSimpleName());

        System.out.println();
        //获得类的属性
        //getFields:获取public权限的属性数组
        Field[] fields = person.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();

        //getDeclaredFields:获取全部属性
        Field[] declaredFields = person.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println();

        //获得指定的属性
        Field name = person.getDeclaredField("name");
        System.out.println(name);

        System.out.println();

        //获取类的方法
        //getMethods:获取本类及其父类的全部public权限方法
        Method[] methods = person.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();

        //getDeclaredMethods:获取本类所有方法
        Method[] declaredMethods = person.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println();

        //获取指定方法
        Method getName = person.getMethod("getName", null);
        Method setName = person.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        System.out.println();

        //获取构造器
        //getConstructors:获取本类及父类的public权限构造器
        Constructor[] constructors = person.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();

        //getDeclaredConstructors:获取本类所有的构造器
        Constructor[] declaredConstructors = person.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println();

        //获取指定的构造器
        Constructor declaredConstructor = person.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor);
    }
}
