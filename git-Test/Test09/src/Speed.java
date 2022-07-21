public class Speed {
    public static void main(String[] args) {
        //测试String、StringBuffer与StringBuilder的速度性能

        //系统计时方法
        long l = System.currentTimeMillis();

        String s = new String("aaa");


        for (int i = 0; i < 50000; i++) {
            s+=i;
        }

        long l1 = System.currentTimeMillis();

        System.out.println("String用时:"+(l1-l)+"毫秒");

        long l2 = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("aaa");

        for (int i = 0; i < 50000; i++) {
            sbf.append(String.valueOf(i));
        }

        long l3 = System.currentTimeMillis();

        System.out.println("StringBuffer用时:"+(l3-l2)+"毫秒");

        long l4 = System.currentTimeMillis();
        StringBuilder sbd = new StringBuilder("aaa");

        for (int i = 0; i < 50000; i++) {
            sbd.append(String.valueOf(i));
        }

        long l5 = System.currentTimeMillis();

        System.out.println("StringBuilder用时:"+(l5-l4)+"毫秒");


//        String用时:8232毫秒
//        StringBuffer用时:16毫秒
//        StringBuilder用时:4毫秒

        //效率：StringBuilder > StringBuffer > String
    }
}
