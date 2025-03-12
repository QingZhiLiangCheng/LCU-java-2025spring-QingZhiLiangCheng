package cn.edu.lcu.cs.javaprogramming.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 数学工具类的测试类
 * 2022/3/2 0:39
 *
 * @Author ling
 */
class MathTest {

    @Test
    void sumInt() {
        int x = 1;
        int y = 2;
        System.out.println(Math.sum(x, y));
        System.out.println(Math.sum(x, y, 3, 4, 5));
        // 百度搜索：130:2
        System.out.println(Math.sum(130, 2, 49));
    }

    @Test
    void sumLong() {
        // 10亿，下划线是分隔符
        long x = 10_0000_0000;
        // 68亿，这个数超出了int的表示范围，需加后缀L
        long y = 68_0000_0000L;
        System.out.println(Math.sum(x, y));
    }

    /**
     * <p>参数化测试</p>
     * <p>指定若干个逗号分隔的量，依次自动给方法参数赋值并测试</p>
     *
     * @param x
     * @param y
     */
    //@Test
    @ParameterizedTest
    @CsvSource({"1,2", "3,4"})
    void sumShort(short x, short y) {
        // 控制台直接打印，肉眼观察结果的方法太Low
        System.out.println(Math.sum(x, y));
        // 使用JUnit的各种断言进行判断，高大上
        assertEquals(x + y, Math.sum(x, y));
    }
}