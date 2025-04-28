package cn.edu.lcu.cs.javaprogramming.clazz;

import cn.edu.lcu.cs.javaprogramming.util.Math;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * 日期时间演示
 *
 * @author ling
 * @date 2022/4/7 9:12
 */
public class DateDemo {

    /**
     * 生日计算。
     * 打印出生至今的年数、月数、天数
     *
     * @param year
     * @param month
     * @param day
     */
    @ParameterizedTest
    @CsvSource({"1949,10,1", "49,9,1"})
    void birthdate(int year, int month, int day) {
        //代码填空
        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("day = " + day);
        Date birthdate = new Date(year, month, day);
        System.out.println("birthdate = " + birthdate);


        LocalDate localDate = LocalDate.of(year, month, day);
        System.out.println("localDate = " + localDate);

//        获取当下的时间
        System.out.println("new Date() = " + new Date());
        System.out.println("LocalDate.now() = " + LocalDate.now());
    }

    @AfterEach
    void afterEach() {
        System.out.println("----------------------------------------------------------------");
    }

    /**
     * 时间计算。
     * 打印一个时间段耗费的纳秒数
     */
    @Test
    void duration() {

        // 调用一个比较耗时的操作
        Math.factorialSafe(78);


    }


    /**
     * 母亲节，5月的第2个星期日。
     */
    @Test
    @Deprecated
    void mothersDayDeprecated() {
        // 生成母亲节日期对象
        // 代码填空
        LocalDate mothersDay = LocalDate.now()
                .withMonth(5)       // 月份设置为5月
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
    @Test
    void graduationDay() {
        LocalDate graduationDay = LocalDate.of(2025, 6, 30);
//        LocalDate graduationDay = LocalDate.of(2000, 1, 1);

        // 计算毕业日距今天的天数
        // 代码填空
        LocalDate now = LocalDate.now();
        Period period = now.until(graduationDay);
        System.out.println("period.getYears() = " + period.getYears());
        System.out.println("period.getMonths() = " + period.getMonths());
        System.out.println("period.getDays() = " + period.getDays());

        long years = now.until(graduationDay, ChronoUnit.YEARS);
        long months = now.until(graduationDay, ChronoUnit.MONTHS);
        long days = now.until(graduationDay, ChronoUnit.DAYS);
        System.out.println("years = " + years);
        System.out.println("months = " + months);
        System.out.println("days = " + days);
    }


}
