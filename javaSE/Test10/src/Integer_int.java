public class Integer_int {
    //Integer与int的区别
    //int是基本数据类型,Integer是引用类型
    //通过全局变量初始化来判断
    int a;
    Integer aa;
    //二者的初始化一个为0,一个为null

    public static void main(String[] args) {
//        Integer_int integer_int = new Integer_int();
//        System.out.println(integer_int.a);//0
//        System.out.println(integer_int.aa);//null


        //装箱:int转Integer
        int a = 11;
        Integer integer = new Integer(a);
        System.out.println(integer);

        //Integer虽然是引用类型但是它的底层支持它直接用算术运算符操作
        System.out.println(integer+100);


        //拆箱:Integer转int
        int i = integer.intValue();
        System.out.println(i);

        System.out.println();
        //int转换String
        //1.自动转换
        int num = 1;
        String s = "abc";
        System.out.println(s+=num);

        System.out.println();
        //2.valueOf重载
        String s1 = String.valueOf(1);
        System.out.println(s1);

        System.out.println();
        //String 转换 int
        //1.valueOf重载
        Integer integer1 = Integer.valueOf("123");
        System.out.println(integer1);

        System.out.println();
        //2.parseInt
        int i1 = Integer.parseInt("123");
        System.out.println(i1);

    }
}
