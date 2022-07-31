import entity.Person;

import java.lang.reflect.Method;

public class Test2 {
    //分析性能问题
    //执行方法1000000000次,计算三种方式的耗时

    //普通方式调用
    public static void test01() {
        Person person = new Person();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            person.getName();
        }

        long end = System.currentTimeMillis();
        System.out.println("普通方法执行耗时:"+(end - start)+"ms");
    }

    //反射方式调用
    public static void test02() throws Exception {
        Person person = new Person();
        Class personClass = person.getClass();

        Method getName = personClass.getDeclaredMethod("getName", null);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(person,null);
        }

        long end = System.currentTimeMillis();
        System.out.println("反射方法执行耗时:"+(end - start)+"ms");
    }

    //反射方式调用,关闭安全检测
    public static void test03() throws Exception {
        Person person = new Person();
        Class personClass = person.getClass();

        Method getName = personClass.getDeclaredMethod("getName", null);

        getName.setAccessible(true);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(person,null);
        }

        long end = System.currentTimeMillis();
        System.out.println("反射关闭安全检测执行耗时:"+(end - start)+"ms");
    }

    public static void main(String[] args) throws Exception {
        test01();
        test02();
        test03();
        //根据测试普通方法的效率远远高于反射的效率,
        //这也是实际开发中一般的项目并不会大量使用反射来开发的原因之一
        //反射更多是一种对程序本身的维护,而不是用于开发为主
        //虽然反射突破了private权限,但这并不违背封装的理念
    }
}
