package cn.edu.lcu.cs.javaprogramming.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

// 静态导入
//import static cn.edu.lcu.cs.javaprogramming.util.Math.PI;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static cn.edu.lcu.cs.javaprogramming.util.Math.*;
import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    @Test
    void testMath() {
        // Math是个工具类，没必要实例化。
        // 如何从根本上避免工具类实例化？
//        Math math = new Math();
//        发生了除法异常，整个程序异常退出，导致后续正常的代码也得不到执行
        System.out.println(1 / 0);

        System.out.println(Math.PI);
        System.out.println(PI);

    }

    @Test
    void sumInt() {
        int x = 10_0000_0000;
        int y = 68_0000_000;
        System.out.println(Math.sum(x, y));

        System.out.println(sum(130, 2, 49));
    }

    @Test
    void sumShort() {
        short x = 1;
        short y = 2;
        System.out.println(Math.sum(x, y));

        // 3,4 是整形的字面常量，默认是int类型。
        // 下边语句会调用sum int方法。
//        System.out.println(Math.sum(3, 4));
    }

    @Test
    void sumLong() {
        long x = 10_0000_0000;
        // 68_0000_0000是整型字面常量，默认是int。
        // 68亿超出了int的表示范围。
        // 需要加后缀 l L
        long y = 68_0000_0000L;
//        System.out.println(Math.sum(x, y));
        assertEquals(78_0000_0000L, Math.sum(x, y));
    }

    @Test
    void sumDouble() {

    }

    /**
     * 对阶乘进行测试，所有输入都是有效的。
     */
    @Test
    void factorialWithValidInput() {
        System.out.println(factorial(25));

        assertEquals(1, factorial(0));
        assertEquals(1, factorial(1));
        assertEquals(3628800, factorial(10));
    }

    /**
     * 对阶乘进行测试，所有输入都是无效的。
     * 检验代码是否足够健壮，能否处理这些极端情况。
     */
    @ParameterizedTest
    @ValueSource(longs = {-1, -200})
    void factorialWithInvalidInput(long input) {
        // 对这些无效的输入，代码应该抛出一个参数非法的异常。
        // 所以在测试代码中期待一个异常被抛出。
        assertThrows(IllegalArgumentException.class, () -> factorial(input));
    }

    /**
     * 对阶乘进行测试。
     * 当输入超过阈值之后，阶乘会有溢出。
     * 21的阶乘超出了长整型正数的表示范围。
     */
    @ParameterizedTest
    @ValueSource(longs = {21, 30})
    void factorialWithOverflow(long input) {
        assertThrows(RuntimeException.class, () -> factorial(input));
    }

    /**
     * 一元运算符，求相反数
     */
    @Test
    void unaryOperationOppositeNumber() {
        double num = -3.14;

//        double result = Math.unaryOperation(num, (oper) -> oper * -1);
        double result = Math.unaryOperation(num, new UnaryOperator<Double>() {
            @Override
            public Double apply(Double oper) {
                return oper * -1;
            }
        });

        System.out.println("num = " + num);
        System.out.println("result = " + result);

    }

    @Test
    void binaryOperation() {
        double operand1 = 3;
        double operand2 = -2;

//        BinaryOperator<Double> add = (o1, o2) -> o1 + o2;
        BinaryOperator<Double> add = new BinaryOperator<Double>() {
            @Override
            public Double apply(Double o1, Double o2) {
                return o1 + o2;
            }
        };
        double sum = Math.binaryOperation(operand1, operand2, add);
        double difference = Math.binaryOperation(operand1, operand2, (o1, o2) -> o1 - o2);

        System.out.println("operand1 = " + operand1);
        System.out.println("operand2 = " + operand2);
        System.out.println("sum = " + sum);
        System.out.println("difference = " + difference);
    }

    @ParameterizedTest
    @CsvSource({"10,10", "3,2", "2,3"})
    void divide(double dividend, double divisor) {
        System.out.printf("Math.divide(%f, %f) = %f\n", dividend, divisor, Math.divide(dividend, divisor));
    }
}