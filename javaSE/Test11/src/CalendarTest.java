import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        //Calendar类
        //getInstance获取
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //get
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println();
        //set
        calendar.set(Calendar.YEAR, 3202);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println();
        //add
        calendar.add(Calendar.YEAR, 100);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.add(Calendar.YEAR, -100);
        System.out.println(calendar.get(Calendar.YEAR));

        System.out.println();
        //Date--Calendar
        //getTime实现Calender转为Date对象
        Date time = calendar.getTime();
        System.out.println(time);
        System.out.println();
        //setTime用Date来设置Calendar的值
        calendar.setTime(new Date(1527163813861L));
        System.out.println(calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
        System.out.println();
        //Date偏移量问题

        //由于Date最初设计时的底层导致其并不适合用来手动构造一个时间
        //它所构造的年份与实际年份相差1900,月份与实际月份相差1
        //Date默认用12小时制

        //为了解决这个问题引入了LocalDate、LocalTime、LocalDateTime
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date date = new Date(2022, 6, 17, 19, 49, 30);
        System.out.println(simpleDateFormat1.format(date));

        Date date1 = new Date(2022-1900, 6-1, 17, 19, 49, 30);

        System.out.println(simpleDateFormat1.format(date1));
    }
}
