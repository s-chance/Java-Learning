import org.junit.Test;

import java.util.Random;
public class ReflectionTest2 {
    //通过反射体现运行时类的对象

    //反射的动态性
    //运行前并不知道对象,只有在运行之后才知道
    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            //随机数字 1 2 3
            int num = new Random().nextInt(3);
            String classPath = "";
            //这里的classPath的内容是有规定的,不是随便写的
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "entity.Person";
                    break;
            }

            //反射通过获取classPath再创建一个Object对象
            //由于Object对象是所有对象的父类,通过打印根据classPath获取的Object对象就能知道子对象是什么

            try {
                Object object = getInstance(classPath);
                System.out.println(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //创建一个指定类对象
    public Object getInstance(String classPath) throws Exception {
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
