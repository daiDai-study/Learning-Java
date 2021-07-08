package org.daistudy.onjava.datetime.javatime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.TimeZone;

/**
 * @Author 60056306
 * @Date 2020/6/16 18:07
 * @Version 1.0
 **/
public class SimpleLocalDateTimeDemo {
    public static void main(String[] args) {
        // 严格按照ISO 8601格式打印
        System.out.println("LocalDate.now() = " + LocalDate.now());
        System.out.println("LocalTime.now() = " + LocalTime.now());
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
        System.out.println("LocalDateTime.now().toLocalDate() = " + LocalDateTime.now().toLocalDate());
        System.out.println("LocalDateTime.now().toLocalTime() = " + LocalDateTime.now().toLocalTime());

        LocalDate d2 = LocalDate.of(2019, 11, 30); // 2019-11-30, 注意11=11月
        LocalTime t2 = LocalTime.of(15, 16, 17); // 15:16:17
        System.out.println(d2);
        System.out.println(t2);
        LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
        LocalDateTime dt3 = LocalDateTime.of(d2, t2);
        System.out.println(dt2);
        System.out.println(dt3);

        System.out.println("LocalDateTime.parse(\"2019-11-19T15:16:17\") = " + LocalDateTime.parse("2019-11-19T15:16:17"));
        System.out.println("LocalDate.parse(\"2019-11-19\") = " + LocalDate.parse("2019-11-19"));
        System.out.println("LocalTime.parse(\"15:16:17\") = " + LocalTime.parse("15:16:17"));

        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        System.out.println("LocalDateTime.parse(\"2019/11/30 15:16:17\", dtf) = " + LocalDateTime.parse("2019/11/30 15:16:17", dtf));

        LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt);
        // 加5天减3小时:
        System.out.println("dt.plusDays(5).minusHours(3) = " + dt.plusDays(5).minusHours(3));// 2019-10-31T17:30:59
        // 减1月:
        System.out.println("dt2.minusMonths(1) = " + dt.minusMonths(1));// 2019-09-30T17:30:59

        LocalDateTime dt4 = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt4);
        // 日期变为31日:
        LocalDateTime dt5 = dt4.withDayOfMonth(31);
        System.out.println(dt5); // 2019-10-31T20:30:59
        // 月份变为9:
        LocalDateTime dt6 = dt5.withMonth(9);
        System.out.println(dt6); // 2019-09-30T20:30:59


        // 本月第一天0:00时刻:
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);

        // 本月最后1天:
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);

        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);

        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);

    }
}
