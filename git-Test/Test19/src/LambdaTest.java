import org.junit.Test;

import java.util.Comparator;

public class LambdaTest {
    @Test
    public void test() {
        //普通写法,实现一个Runnable接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        runnable.run();

        //普通写法,实现一个Comparator接口
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare = comparator.compare(88, 77);
        System.out.println(compare);
    }

    @Test
    public void lambdaTest() {

        //这里出现了lambda中关键的操作符 ->
        //lambda语法的简单描述
        /*
        * =  左边是对象,右边是参数列表
        * ->  左边是参数列表,右边是具体的执行语句
        * 参数列表中的参数不需要指明数据类型
        * 格式:  类名 名称 = (参数1,参数2...) -> 执行语句*/


        //lambda语法,实现Runnable接口
        Runnable runnable = () -> System.out.println("lambda");
        runnable.run();

        //lambda语法,实现Comparator接口
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        int compare = comparator.compare(21, 44);
        System.out.println(compare);

        //:: 是另一个lambda表达式的关键字,直接在::后面引用类或对象指定的方法即可
        Comparator<Integer> compare1 = Integer::compare;
        int compare2 = compare1.compare(23, 78);
        System.out.println(compare2);
    }

}
