import org.junit.Test;

public class ClassLoaderTest {
    //类的加载器
    //这边对获取Class实例的方式四做进一步说明

    @Test
    public void test1() {
        //对于自定义类,使用系统加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent  获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        //调用扩展类加载器的getParent  无法获取引导类
        //引导类的加载器主要负责加载java的核心库类,无法加载自定义类
        ClassLoader loader = parent.getParent();
        System.out.println(loader);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
