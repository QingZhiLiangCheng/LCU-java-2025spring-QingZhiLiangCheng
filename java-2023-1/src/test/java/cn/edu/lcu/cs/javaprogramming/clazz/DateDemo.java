package cn.edu.lcu.cs.javaprogramming.clazz;

import cn.edu.lcu.cs.javaprogramming.util.Math;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

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
    @CsvSource({"1949,10,1"})
    void birthdate(int year, int month, int day) {
        //代码填空


    }

    /**
     * 时间计算。
     * 打印一个时间段耗费的纳秒数
     *
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
    void mothersDay() {
        LocalDate mothersDay = LocalDate.now();

        // 生成母亲节日期对象
        // 代码填空


        System.out.println("mothersDay = " + mothersDay);
    }

    /**
     * 毕业倒计时
     */
    @Test
    void graduationDay() {
        LocalDate graduationDay = LocalDate.of(2024, 6, 30);


        // 计算毕业日距今天的天数
        long days = 0;
        // 代码填空



        System.out.println("days = " + days);
    }


}
