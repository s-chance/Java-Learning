import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        //Date类
        Date date = new Date();

        //getTime获取时间
        System.out.println(date.getTime());

        //setTime设置时间
        long l = System.currentTimeMillis();
        date.setTime(l);

        //toString
        System.out.println(date);
        System.out.println(date.toString());
        //
        //创建Date
        //无参Date date = new Date();

        //有参
        Date date1 = new Date(2022742648827L);
        System.out.println(date1);

        //格式化
        //SimpleDateFormat
        //无参
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date1);
        System.out.println(format);

        System.out.println();
        //有参
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = simpleDateFormat1.format(date1);
        System.out.println(format1);

        //字符串日期重构为Date
        //parse
        String str = "Fri Jun 17 19:35:23 CST 2022";
        //带有下划线的关键字表示已经过时的方法,但还可以使用
        long parse = Date.parse(str);
        System.out.println(parse);
    }
}
