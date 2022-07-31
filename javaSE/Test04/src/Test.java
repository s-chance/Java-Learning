import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //异常续 异常处理 try-catch-finally语句
        //其中try-catch必须一起写出来，try只有一个，catch可有多个
        //try的顺序优先于catch，catch与catch之间则从上到下执行，
        // 每个catch可对应不同的异常，但Exception是所有异常的父类，它应该写在最后
        //finally语句可写可不写，但finally语句中的代码一般情况下都会执行

        //抛出异常 throws Exception 写在方法参数列表之后
        //这个时候调用该方法时就必须进行异常处理，相当于标记了这个方法，使编译器能够识别异常标记来要求处理这个方法

        //手动抛出异常 throw new Exception 手动抛出一个异常，尽管代码本身没有问题


        //自定义异常内容  从Exception源码可以看到它继承了Throwable类
        //那么通过继承Throwable类用构造方法调用父类内容就能自定义异常的内容

        Test t = new Test();
//        try {
//            System.out.println(t.err());
//        } catch (Exception e) {
//            e.printStackTrace();//默认的异常打印方法,看上去不适应也可用Exception的getMessage方法
//            //e.getMessage();
//
//        } finally {
//            System.out.println("finally");
//        }
        try {
            System.out.println(t.err());
            System.out.println("Hello");
        } catch (MyException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }
        //Ctrl+Alt+t快捷键实现基本的异常处理

    }

    public int err() throws MyException {
        int a = 1;

        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        if(a * b == 0) {
            throw new MyException("zero is not allowed");
        } else {
            System.out.println("pass");
        }
        return a / b;
    }
}
