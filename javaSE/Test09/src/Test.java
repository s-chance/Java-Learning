import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //API  String的相关使用
        //String的输入
        Scanner scanner = new Scanner(System.in);

        //注意到使用next()方法不能在中间输入空格字符
        //当输入空格或者Tab键使字符的输入已经完成

        //要输入空格字符，可以使用nextLine()方法
//        String str1 = scanner.next();
//        System.out.println("str1 = " + str1);
//        String str2 = scanner.nextLine();
//        System.out.println("str2 = " + str2);

        //String本身实际上是一个final修饰的类，这意味着String本身并不可变

        String s1 = "abc";

        String ss1 = s1.replace("a", "c");
//        System.out.println(s1);//s1的值并没有因为replace方法改变，而是重新赋值给一个新的String
//        System.out.println(ss1);

        //String实例化有两种方式
        //字面量，即直接声明赋值
        String s2 = "abc";
        //构造方法创建一个String对象
        String os1 = new String("abc");
        String os2 = new String("abc");

        //但这两种方式所创建出来的对象有一定的区别
        //通过new所创建的对象比较的不是它们的数据值，而是它们的地址值

        System.out.println(s1);
        System.out.println(os1);
        System.out.println(os2);
        System.out.println(s1==s2);

        System.out.println(s1==os1);

        System.out.println(s1==os2);

        System.out.println(os1==os2);

        System.out.println(os1.equals(os2));

    }
}
