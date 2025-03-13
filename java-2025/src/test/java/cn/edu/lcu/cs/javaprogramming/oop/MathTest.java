package cn.edu.lcu.cs.javaprogramming.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // TODO 演示参数化测试

    /**
     * 测试阶乘方法的参数化测试
     *
     * @param n        输入的非负整数
     * @param expected 预期的阶乘结果
     */
    @ParameterizedTest
    @CsvSource({
            "0, 1",   // 0! = 1
            "1, 1",   // 1! = 1
            "2, 2",   // 2! = 2
            "3, 6",   // 3! = 6
            "4, 24",  // 4! = 24
            "5, 120",  // 5! = 120
            "6, 720", //
            "7, 5040", //
            "8, 40320", //
            "9, 362880", //
            "10, 3628800", //
            "11, 39916800", //
            "12, 479001600"
    })
    void testFactorial(int n, long expected) {
        assertEquals(expected, Math.factorial(n));
    }

    /**
     * 测试阶乘方法对于负数的异常处理
     */
    @ParameterizedTest
    @CsvSource({"-1",  // 负数，应该抛出异常
            "-5"   // 负数，应该抛出异常
    })
    void testFactorialNegative(int n) {
        assertThrows(IllegalArgumentException.class, () -> Math.factorial(n));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",   // 0! = 1
            "1, 1",   // 1! = 1
            "2, 2",   // 2! = 2
            "3, 6",   // 3! = 6
            "4, 24",  // 4! = 24
            "5, 120",  // 5! = 120
            "6, 720", //
            "7, 5040", //
            "8, 40320", //
            "9, 362880", //
            "10, 3628800", //
            "11, 39916800", //
            "12, 479001600"
    })
    void testFactorialRecursive(int n, long expected) {
        assertEquals(expected, Math.factorialRecursive(n));
    }

    @ParameterizedTest
    @CsvSource({"-1",  // 负数，应该抛出异常
            "-5"   // 负数，应该抛出异常
    })
    void testFactorialRecursiveNegative(int n) {
        assertThrows(IllegalArgumentException.class, () -> Math.factorialRecursive(n));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "5, 120",
        "6, 720",
        "7, 5040",
        "8, 40320",
        "9, 362880",
        "10, 3628800",
        "11, 39916800",
        "12, 479001600"
    })
    void testFactorialRecursivePerformance(int n, long expected) {
        // 记录开始时间
        long startTime = System.nanoTime();

        // 调用方法
        long result = Math.factorialRecursive(n);

        // 记录结束时间
        long endTime = System.nanoTime();

        // 计算运行时间
        long duration = (endTime - startTime) ;

        // 验证结果
        assertEquals(expected, result);

        // 打印运行时间
        System.out.println("FactorialRecursive(" + n + ") execution time: " + duration + " ns");
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "5, 120",
        "6, 720",
        "7, 5040",
        "8, 40320",
        "9, 362880",
        "10, 3628800",
        "11, 39916800",
        "12, 479001600"
    })
    void testFactorialPerformance(int n, long expected) {
        // 记录开始时间
        long startTime = System.nanoTime();

        // 调用方法
        long result = Math.factorial(n);

        // 记录结束时间
        long endTime = System.nanoTime();

        // 计算运行时间
        long duration = (endTime - startTime) ;

        // 验证结果
        assertEquals(expected, result);

        // 打印运行时间
        System.out.println("Factorial(" + n + ") execution time: " + duration + " ns");
    }
}