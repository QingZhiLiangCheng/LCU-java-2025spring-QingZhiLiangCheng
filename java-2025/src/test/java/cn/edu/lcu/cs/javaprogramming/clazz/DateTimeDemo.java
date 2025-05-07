package cn.edu.lcu.cs.javaprogramming.clazz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    /**
     * 执行某个操作，该操作主要负责在控制台输出从0到99999的一系列数字
     * 该方法展示了如何使用循环来批量输出数据，而不是逐个手动输出
     */
    private void doSomething() {
        // 定义计数变量，表示需要输出的数字数量
        int count = 100000;
        // 使用for循环，迭代输出从0到count-1的数字
        for (int i = 0; i < count; i++) {
            // 输出当前迭代的数字，使用制表符进行分隔，以保持输出的整洁和有序
            System.out.print(i + "\t");
        }
        // 在所有数字输出完毕后，添加一个换行符，以便后续的输出不会紧接在数字之后
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
    @Deprecated
    void mothersDayDeprecated() {
        // 生成母亲节日期对象
        // 代码填空
        LocalDate mothersDay = LocalDate.now().withMonth(5)       // 月份设置为5月
                .withDayOfMonth(1)  // 设置为1号
                // 将日期调整到最近的星期日（7表示星期日）。
                // 如果5月1日已经是星期日，则不会改变日期；否则，会调整到最近的星期日。
                .with(ChronoField.DAY_OF_WEEK, 7)
                // 在调整后的日期基础上增加一周。
                .plusWeeks(1);

        // 问题点
        //5月1日不一定是第一个星期日：
        //如果5月1日不是星期日，with(ChronoField.DAY_OF_WEEK, 7) 会调整到最近的星期日，这可能是5月的某个星期日，但不一定是第一个星期日。
        //增加一周可能导致错误的结果：
        //增加一周后，日期可能会跳过第一个星期日，直接到第二个星期日之后的某个日期。
        System.out.println("mothersDay = " + mothersDay);
    }

    /**
     * 母亲节，5月的第2个星期日。
     */
    @Test
    void mothersDay() {
        // 获取当前年份
        int currentYear = LocalDate.now().getYear();

        // 生成母亲节日期对象
        LocalDate mothersDay = LocalDate.of(currentYear, 5, 1)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)) // 调整到5月的第一个星期日
                .plusWeeks(1); // 加上一周，得到第二个星期日

        System.out.println("mothersDay = " + mothersDay);
    }


    /**
     * 毕业倒计时
     */
    @ParameterizedTest
    @CsvSource({"2025, 6, 30", "2026, 6, 30", "2027, 6, 30"})
    void graduationDay(int year, int month, int day) {
        LocalDate graduationDay = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period period = Period.between(now, graduationDay);
        long days = now.until(graduationDay, ChronoUnit.DAYS);
//        System.out.println("到毕业那一天（" + graduationDay + "）还有" + days + "天");
        System.out.printf("到毕业那一天（%s）还有 %d 天%n", graduationDay, days);
        System.out.printf("到毕业那一天（%s）还有 %d 月%n", graduationDay, now.until(graduationDay, ChronoUnit.MONTHS));
        System.out.printf("到毕业那一天（%s）还有 %d 年%n", graduationDay, now.until(graduationDay, ChronoUnit.YEARS));
        System.out.printf("到毕业那一天（%s）还有 %d 年 %d 个月 %d 天%n", graduationDay, period.getYears(), period.getMonths(), period.getDays());
    }

    @AfterEach
    void tearDown() {
        System.out.println("-".repeat(50));
    }

}