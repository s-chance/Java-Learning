public class IntegerTest2 {
    public static void main(String[] args) {
        //构造方法创建
        Integer integer = new Integer(10);
        Integer integer1 = new Integer("10");

        //静态方法创建
        Integer integer2 = Integer.valueOf(10);
        Integer integer3 = Integer.valueOf("10");

        System.out.println(integer);
        System.out.println(integer1);
        System.out.println(integer2);
        System.out.println(integer3);


    }
}
