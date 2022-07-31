import java.util.Scanner;

public class Test extends Object {
    public static void main(String[] args) {
        //Object类 所有类的父类或者"祖宗"类  按住Ctrl,再用鼠标点击类名可查看该类源码
        //可以看到String类型比较的方法equals方法就来自于Object类
        //现在尝试重写Object类的equals方法,重写方法需保证方法名\参数\返回值\权限均一致

        Object o = new Test();
        //Object类指向Test类, 父类指向子类  面向对象的第三个特性:多态
        Pet pd = new Dog("doge",12,20);
        Pet pc = new Cat("coffee",11,40);

        //调用父类的方法实际上是调用了子类中重写的方法,但是子类中特有的方法无法调用
        //pd.df
        pd.f1();
        pc.f1();

        Dog d = new Dog("doge",12,20);
        Cat c = new Cat("coffee",11,40);
        Host h = new Host();
        h.feed(d);
        h.feed(c);

//        for(int i=0;i<3;i++) {
//            Scanner sc = new Scanner(System.in);
//            int a = sc.nextInt();
//            if(o.equals(a)) {
//                System.out.println("输出1");
//            } else {
//                System.out.println("不是1");
//            }
//        }


    }

    public boolean equals(Object obj) {
        if((int)obj==1) {
            return true;
        } else {
            return false;
        }

    }
}
