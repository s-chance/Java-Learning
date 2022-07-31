import java.util.*;

public class Test {
    public static void main(String[] args) {
        //list集合  ArrayList
        List list = new ArrayList();  //创建集合

        List linked = new LinkedList();
        //List集合中的另一种集合，相比ArrayList,其对数据的修改更加高效，但查询遍历则相对不如ArrayList
        //关于LinkedList中的方法，感兴趣的可以去源码查找使用，也可以通过API查询(相当于一种帮助文档)


        //集合是比数组更加强大的数据结构，单一的数组只能接受一种数据类型，而list集合可以接受不同的数据类型
        //此外list集合的大小可根据添加的元素实现动态变化
        //实际上很多关于类的方法，可以直接去源码里寻找，并且根据自身水平适当地去理解源码，能更好地编写程序


        //list集合的主要操作  添加、删除、修改、查询


        //添加元素
        list.add("Hello");
        list.add("World");
        list.add(2022);
        list.add(false);
        //包括对象以及集合本身，list集合也能添加
        Student s = new Student("xm",12,66);
        list.add(s);
        //注意到Student对象中的内容并没有打印出来，而是打印出了地址。
        //这里就需要重写Student对象的toString()方法


        List ll = new ArrayList();

        ll.add("外层集合头");
        ll.add(list);

        //将两个集合中的元素合并成一个集合  addAll()方法
        //ll.addAll(list);
        ll.add("外层集合尾");


        ll.add(3,"TT");

        //此外通过下标添加元素需要注意下标不能大于集合当前的尺寸,否则IndexOutOfBoundsException
        //ll.add(5,"TT");
        //ll.add(-1,"TT");
        System.out.println(ll.size());
        Iterator it1 = ll.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        System.out.println();

        //删除元素
//        ll.remove(list);
//        ll.remove(ll.size()-1);

        //修改元素
//        ll.set(1,"the Second Index");

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }


        Scanner scanner = new Scanner(System.in);
        //查询元素 就是提供get()方法实现
        int index;
        do {
            index = scanner.nextInt();
            System.out.println(ll.get(index));
        } while (index != -1);


        //集合的遍历一：普通for获取下标
//        for (int i = 0; i < ll.size(); i++) {  //size()方法,返回集合的大小
//            System.out.println(ll.get(i));     //get()方法,获取下标对应的值
//        }

        //集合的遍历二：增强for   快捷键iter+enter
//        for (Object list1 : ll) {
//            System.out.println(list1);
//        }

        //集合的遍历三：iterator迭代器,仅限集合使用
        //hasNext判断集合下一位是否有值,也就说迭代器最开始是指向集合中第一个元素的前面
        //next返回下一位的值
        //iterator迭代器不需要提供集合下标，这有利于处理某些不存在下标的集合
        Iterator it = ll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
