import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class IntegerTest {
    public static void main(String[] args) {
        double a = 1.1;
        double b = 0.69;
        System.out.println(a+b);
        System.out.println(a-b);//计算不精准

        //为了进行精确的运算,可以使用BigDecimal,注意这个不能直接用算术运算符操作
        BigDecimal bigDecimal = new BigDecimal(1.1);
        BigDecimal bigDecimal1 = new BigDecimal(0.69);
        BigDecimal divide = bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_HALF_UP);
        BigDecimal subtract = bigDecimal.subtract(bigDecimal1);
        System.out.println(divide);
        System.out.println(subtract);
        System.out.println();
        //BigInteger则是针对大int的数据运算
        //int m = 10000000000000;
        BigInteger bigInteger = new BigInteger("100000000000");
        System.out.println(bigInteger);
        BigInteger bigInteger1 = new BigInteger("100000000000");
        BigInteger multiply = bigInteger.multiply(bigInteger1);
        System.out.println(multiply);
    }
}
