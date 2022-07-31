import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        //set集合的使用
        Set set = new HashSet();

        set.add(11);
        set.add("hello");
        set.add(new User("hh",12));//重写toString
        set.add(11);//set集合中不允许重复的元素存在

        //set集合没有下标，因此无法用普通的for循环实现

        //增强for
        for (Object o : set) {
            System.out.println("o = " + o);
        }

        //迭代器
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //十六进制的转换，   hashcode哈希值，每个对象都具有一个哈希值
        int ll = new User("ll", 32).hashCode();//需要重写hashcode方法
        String s = Integer.toHexString(ll);//十六进制转换
        System.out.println(ll + "->" + s);
        //每次创建对象都会生成一个新的哈希值

        //哈希值是否可能重复？
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());
        //不同的对象可能具有同一个哈希值

        //匿名内部类的使用,不需要对象名，直接调用一次且只调用一次，简化代码
        new Action() {
            @Override
            public void run() {
                System.out.println("run");
            }
        }.run();
    }
}
