import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTest {
    public static void main(String[] args) {
        //of方法设置Local系列类的值

        //LocalDate设置年月日
        LocalDate localDate = LocalDate.of(2022, 6, 17);
        System.out.println(localDate);
        System.out.println();
        //LocalTime设置时分秒
        LocalTime localTime = LocalTime.of(19, 49, 30);
        System.out.println(localTime);
        System.out.println();
        //LocalDateTime设置年月日时分秒
        LocalDateTime localDateTime = LocalDateTime.of(2022, 6, 17, 19, 49, 30);
        System.out.println(localDateTime);

        //以下是Local系列的通用方法
        //get...
        System.out.println(localDate.getMonth());
        System.out.println(localTime.getHour());
        System.out.println(localDateTime.getMinute());
        //with...

        //打印该年份指定的一天
        System.out.println(localDate.withDayOfYear(1));
        System.out.println(localTime.withHour(12));

        //打印该月份指定的一天
        System.out.println(localDateTime.withDayOfMonth(2));
        //plus...
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = localDateTime.plusMonths(11L);
        System.out.println(localDateTime1);
        //minus...
        LocalDateTime localDateTime2 = localDateTime.minusMonths(3L);
        System.out.println(localDateTime2);

        System.out.println();

        //LocalDateTime--LocalDate--LocalTime
        //toLocalDate实现LocalDateTime转为LocalDate
        LocalDate localDate1 = localDateTime2.toLocalDate();
        System.out.println("localDate1 = " + localDate1);
        System.out.println();

        //toLocalTime实现LocalDateTime转为LocalTime
        LocalTime localTime1 = localDateTime2.toLocalTime();
        System.out.println("localTime1 = " + localTime1);
        System.out.println();
    }
}
