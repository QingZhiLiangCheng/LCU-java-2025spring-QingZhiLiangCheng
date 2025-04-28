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
     * 毕业倒计时
     */
    @Test
    void graduationDay() {
        LocalDate graduationDay = LocalDate.of(2026, 6, 30);
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
