package cn.edu.lcu.cs.javaprogramming.clazz;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeDemo {

    /**
     * LocalDateTime与Instant
     */
    @Test
    public void LocalDateTimeAndInstant() {
        // 获取当前时区的当前时间，转换instant后，会比当前时间早8小时
        LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
        // 获取当前时区的计算距离标准格林威治时间偏移量的时间，转换instant后，会是当前时区的正确时间戳
        LocalDateTime.now().atZone(ZoneOffset.UTC).toInstant();
        // 同上
        LocalDateTime.now().toInstant(ZoneOffset.UTC);
        // instant转LocalDatetime，获取当前时区的localDateTime
        LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());

    }

    /**
     * 日期解析与格式化
     */
    @Test
    public void parseAndFormateDate() {
        LocalDate parsedDate = LocalDate.parse("2021-04-24");
        System.out.println(parsedDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        parsedDate = LocalDate.parse("2021.04.24", formatter);
        System.out.println(parsedDate.format(formatter));
    }

    /**
     * Duration时刻之间的时间间隔。
     */
    @Test
    public void duration() {
        Instant begin = Instant.now();
        doSomething();
        Instant end = Instant.now();
        Duration duration = Duration.between(begin, end);
        // 返回两个时间点之间的总纳秒数，比如 4074751400
        System.out.println("循环消耗纳秒：" + ChronoUnit.NANOS.between(begin, end));
        // 返回一个时间段的纳秒数（在一秒钟之内），如 74751400
        System.out.println("循环消耗纳秒：" + duration.getNano());
        System.out.println("循环消耗毫秒：" + duration.toMillis());
        System.out.println("循环消耗毫秒：" + ChronoUnit.MILLIS.between(begin, end));
    }

    private void doSomething() {
        int count = 100000;
        for (int i = 0; i < count; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    /**
     * Period日期之间的天数
     */
    @Test
    public void period() {
        Period oneDay = Period.ofDays(1);
        System.out.println("oneDay = " + oneDay);
        System.out.println("oneDay.withDays(2) = " + oneDay.withDays(2));

        LocalDate birthdate = LocalDate.of(1949, 10, 1);
        LocalDate now = LocalDate.now();

        Period lifePeriod = Period.between(birthdate, now);
        System.out.println("lifePeriod = " + lifePeriod);
        System.out.println("lifePeriod.toTotalMonths() = " + lifePeriod.toTotalMonths());
        System.out.printf("我的一生：%d年%d个月%d天\n", lifePeriod.getYears(), lifePeriod.getMonths(), lifePeriod.getDays());

        // 返回两个时间对象之间的总单位数
        System.out.println("我的一生经历的年数：" + ChronoUnit.YEARS.between(birthdate, now));
        System.out.println("我的一生经历的月数：" + ChronoUnit.MONTHS.between(birthdate, now));
        System.out.println("我的一生经历的天数：" + ChronoUnit.DAYS.between(birthdate, now));

        // until 返回两个时间对象之间的总单位数
        long untilDays = birthdate.until(now, ChronoUnit.DAYS);
        System.out.println("untilDays = " + untilDays);

        System.out.println(now.until(birthdate, ChronoUnit.DAYS));

        System.out.println("lifePeriod = " + lifePeriod);
        System.out.println("lifePeriod.withDays(1) = " + lifePeriod.withDays(1));
    }

    /**
     * 日期演算
     */
    @Test
    public void dateCalculate() {
        // 解析高考日期
        LocalDate parsedDate = LocalDate.parse("2021-06-7", DateTimeFormatter.ofPattern("yyyy-M-d"));
        System.out.println(parsedDate);
        // 高考倒计时100天起始日
        System.out.println(parsedDate.minusDays(100));
    }

    /**
     * 传统Date API演示，不建议使用
     */
    @Test
    public void date() {
        Date now = new Date();
        System.out.println(now);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(formatter.format(now));

        // Date 类很古老，设计混乱，代码混乱，不方便日期时间的计算
        // 在全新软件开发中避免使用此类
        Date birthdate = new Date(1949, 10, 1);
        System.out.println(birthdate);
    }

    /**
     * 日期调整
     */
    @Test
    void localDateTime() {
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

        LocalDate mothersDay = LocalDate.now().withMonth(5).with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
        System.out.println("mothersDay = " + mothersDay);
    }

    /**
     * 母亲节，5月的第2个星期日。
     */
    @Test
    void mothersDay() {
        // 用时间调整器
        //LocalDate mothersDay = LocalDate.now().withMonth(5).with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY));

        LocalDate mothersDay = LocalDate.now()
                .withMonth(5)
                .withDayOfMonth(1)
                .plusWeeks(1)
                .with(ChronoField.DAY_OF_WEEK, 7);
        //LocalDate mothersDay = LocalDate.now().withMonth(5).withDayOfMonth(1).with(ChronoField.DAY_OF_WEEK, 7).plusWeeks(1);
        System.out.println("mothersDay = " + mothersDay);
    }

    /**
     * 毕业倒计时
     */
    @Test
    void graduationDay() {
        LocalDate graduationDay = LocalDate.of(2024, 6, 30);
        long days = LocalDate.now().until(graduationDay, ChronoUnit.DAYS);
        System.out.println("days = " + days);
    }


}