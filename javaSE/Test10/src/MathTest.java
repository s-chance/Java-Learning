public class MathTest {
    public static void main(String[] args) {
        //math类
        //abs求绝对值
        int num = -12;
        int num2 = 22;
        System.out.println(Math.abs(num));
        System.out.println(Math.abs(num2));

        System.out.println();
        //ceil浮点数向上取整,不考虑四舍五入
        double d = 1.1;
        double d2 = 1.9;
        double d3 = -1.9;
        double d4 = -1.1;
        System.out.println(Math.ceil(d));
        System.out.println(Math.ceil(d2));
        System.out.println(Math.ceil(d3));
        System.out.println(Math.ceil(d4));
        System.out.println();
        //floor浮点数向下取整,不考虑四舍五入
        System.out.println(Math.floor(d));
        System.out.println(Math.floor(d2));
        System.out.println(Math.floor(d3));
        System.out.println(Math.floor(d4));
        System.out.println();


        //round浮点数四舍五入取整
        System.out.println(Math.round(d));
        System.out.println(Math.round(d2));
        System.out.println(Math.round(d3));
        System.out.println(Math.round(d4));
        System.out.println(Math.round(1.5));

        System.out.println();

        //max取指定区间最大值
        System.out.println(Math.max(1,11));
        System.out.println(Math.max(1.1, 22));
        System.out.println(Math.max(11, 2));
        System.out.println(Math.max(-11,12.1));
        System.out.println();
        //min取指定区间最小值
        System.out.println(Math.min(1,11));
        System.out.println(Math.min(1.1, 22));
        System.out.println(Math.min(11, 2));
        System.out.println(Math.min(-11,12.1));
        System.out.println();
        //random随机数生成,不加int强转的话,默认是浮点数
        //加区间限制,以1-100为例
        for (int i = 0; i < 3; i++) {
            double random = Math.random()*100+1;
            System.out.println((int)random);
        }
        System.out.println();
        //pow幂数运算
        System.out.println(Math.pow(3, 4));//相当于3的四次方
    }
}
