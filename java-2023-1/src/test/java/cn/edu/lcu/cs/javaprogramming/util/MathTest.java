package cn.edu.lcu.cs.javaprogramming.util;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import cn.edu.lcu.cs.javaprogramming.exception.DividedByZeroException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// 静态导入
//import static cn.edu.lcu.cs.javaprogramming.util.Math.PI;
import java.math.BigInteger;
import java.util.function.BinaryOperator;

import static cn.edu.lcu.cs.javaprogramming.util.Math.*;
import static org.junit.jupiter.api.Assertions.*;

class MathTest extends BaseTest {

    @Test
    void testDivideByZero() {
        int i = 1 / 0;
//        i.soutv
        System.out.println("i = " + i);
    }

    @Test
    void testMath() {
        // Math是个工具类，没必要实例化。
        // 如何从根本上避免工具类实例化？
//        Math math = new Math();
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
     * 循环计算阶乘。 <br>
     * 20是临界值，超过20的Long类型阶乘会溢出。 <br>
     * 即阶乘的结果超出了Long类型64位补码的表示范围。
     * 超出的部分被丢弃，剩余的低64位按照补码来解释，就有可能解读为负数。
     * factorial(18) = 6402373705728000
     * factorial(19) = 121645100408832000
     * factorial(20) = 2432902008176640000
     * factorial(21) = -4249290049419214848
     * factorial(22) = -1250660718674968576
     * factorial(23) = 8128291617894825984
     * factorial(24) = -7835185981329244160
     * factorial(25) = 7034535277573963776
     * factorial(26) = -1569523520172457984
     */
    @Test
    void factorials() {
        for (int i = 0; i < 30; i++) {
            try {
                System.out.println("factorial(" + i + ") = " + factorial(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 循环计算阶乘。 <br>
     * 用BigInteger计算的阶乘。 <br>
     * factorialSafe(20) = 2432902008176640000
     * factorialSafe(21) = 51090942171709440000
     * factorialSafe(22) = 1124000727777607680000
     * factorialSafe(23) = 25852016738884976640000
     * factorialSafe(24) = 620448401733239439360000
     * factorialSafe(25) = 15511210043330985984000000
     * factorialSafe(26) = 403291461126605635584000000
     * factorialSafe(27) = 10888869450418352160768000000
     * factorialSafe(28) = 304888344611713860501504000000
     * factorialSafe(29) = 8841761993739701954543616000000
     */
    @Test
    void factorialSafeDemo() {
        for (int i = 0; i < 30; i++) {
            System.out.println("factorialSafe(" + i + ") = " + factorialSafe(i));
        }
    }

    /**
     * 对阶乘进行测试，所有输入都是有效的。
     */
    @Test
    void factorialWithValidInput() {
        assertEquals(1, factorial(0));
        assertEquals(1, factorial(1));
        assertEquals(3628800, factorial(10));
        assertEquals(2432902008176640000L, factorial(20));
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

        double result = Math.unaryOperation(num, (oper) -> oper * -1);

        System.out.println("num = " + num);
        System.out.println("result = " + result);

    }

    @Test
    void binaryOperation() {
        double operand1 = 3;
        double operand2 = -2;

        BinaryOperator<Double> add = (o1, o2) -> o1 + o2;
        double sum = Math.binaryOperation(operand1, operand2, add);
        double difference = Math.binaryOperation(operand1, operand2, (o1, o2) -> o1 - o2);

        System.out.println("operand1 = " + operand1);
        System.out.println("operand2 = " + operand2);
        System.out.println("sum = " + sum);
        System.out.println("difference = " + difference);
    }

    @Test
    void divide() {
        assertThrows(DividedByZeroException.class, () -> Math.divide(1, 0));
    }

    @Test
    void bigIntegerDemo() {
        BigInteger n = new BigInteger("999999").pow(9999);
        System.out.println("n = " + n);
    }
}