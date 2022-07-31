import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//函数式接口
//
//消费型Consumer
//供给型Supplier
//函数型Function
//断定型Predicate
//函数式接口中内置了很多方法,这边用函数式接口来演示一下lambda表达式的使用

public class LambdaTest3 {
    //消费型Consumer中的accept方法
    @Test
    public void test1() {
        consume(500, new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println("Thanks"+money);
            }
        });

        System.out.println();

        //Lambda写法
        consume(400, money -> System.out.println("Thanks lambda"+money));
    }

    //先定义一个consume方法调用Consumer接口的accept方法
    public void consume(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    //断定型Predicate的test方法,内部可以定义规则进行操作,类似于一个过滤器(区别于javaee中的过滤器,二者不是一个概念)
    @Test
    public void test2() {
        //将数组转换为list集合的方法 Arrays.asList
        //适用于引用数据类型,不适用基本数据类型
        //实时更新
        //不支持add,remove,clear等方法
        List<String> list = Arrays.asList("北京", "南京", "东京", "西京");
        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("北");
            }
        });
        System.out.println(filterString);

        System.out.println();

        //这边的lambda表达式内嵌在普通写法中
        List<String> stringList = filterString(list, s -> s.contains("京"));
        System.out.println(stringList);
    }
    //根据给定的规则,过滤集合中的字符串,此规则由Predicate的方法决定
    //这边根据重写的test方法中返回的Boolean值进行list集合的操作,
    //往集合中添加包含某一字符的集合元素
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
