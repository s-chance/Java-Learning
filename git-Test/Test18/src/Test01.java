import java.util.ArrayList;
import java.util.List;

public class Test01 extends Object {

    //三个内置注解
    //
    //@Override 重写方法
    //@Deprecated 表示某个元素(类、方法等)已过时
    //@SuppressWarnings 用于抑制编译器产生警告信息

    //使用idea快捷键重写方法的时候会出现,不加也不会报错,但为了代码规范还是写上,但idea会自动生成
    @Override
    public String toString() {
        return super.toString();
    }

    //@Deprecated一般是表示即将废弃或已经废弃使用的方法,虽然可能还能使用,但有更好的方法替代
    //有这个注解的情况下,调用这个方法时方法上会出现删除线
    @Deprecated
    public static void test() {
        System.out.println("Deprecated");
    }

    public static void main(String[] args) {
        test();
    }

    //简单来说就是让编译器不显示warning的内容
    @SuppressWarnings("all")
    public void test2() {
        List list = new ArrayList();
    }
}
