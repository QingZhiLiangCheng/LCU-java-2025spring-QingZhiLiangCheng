package cn.edu.lcu.cs.javaprogramming.util;

import cn.edu.lcu.cs.javaprogramming.exception.DividedByZeroException;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author Ling
 */
public class Math {
    public static final double PI = 3.14159;

    private Math() {
    }

    public static void main(String[] args) {
        // 类的静态成员可以在main里直接访问
        System.out.println(PI);

        System.out.println(sum(1, 2));
    }

    public static int sum(int x, int y) {
//        System.out.println("int sum");
        return x + y;
    }

    public static short sum(short x, short y) {
        // + 算术加操作符，先把左右操作数转换为int，再计算，计算结果就是int类型
        return (short) (x + y);
    }

    public static long sum(long x, long y) {
        return x + y;
    }

    public static double sum(double a, double b) {
        return a + b;
    }


    /**
     * 对可变数量的参数求和
     *
     * @param x
     * @param y
     * @param orther 数量可变的参数列表，在方法中可以作为数组处理。
     */
    public static int sum(int x, int y, int... orther) {
        int sum = x + y;
        if (orther != null) {
            for (int i : orther) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * 用递归求阶乘。
     *
     * @param n
     * @return
     */
    @Deprecated
    public static long factorialDeprecated(long n) {
        // 先判断参数的有效性，如果无效，就给用户一个提示
        // 下边这种做法有严重的漏洞
//        if (n < 0) {
//            return -1;
//        }
        // 应该用异常机制，抛出一个异常
        // 如果输入不合法，或者运算溢出，都应该抛出异常


        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * 用递归求阶乘
     *
     * @param n
     * @return
     */
    public static long factorial(long n) {
        if (n > 1) {
            // 应该考虑结果溢出的情况。
            // 如果结果溢出了，应该发出一个警告，中断程序执行，而不是返回溢出后的错误结果。
            // 如果有溢出，正数会转换为负数。
            // ？？？
            long result = n * factorial(n - 1);
            if (result > 0) {
                return result;
            } else {
                throw new RuntimeException("结果溢出：" + n + "! = " + result);
            }
        } else if (n == 1 || n == 0) {
            return 1;
        } else {
            // 如果输入非法，应该发出一个警告，中断程序执行，而不是返回-1。
            // 若返回-1，可能阴差阳错，被当作正确结果使用，造成无法想像的严重后果。
            // ？？？
//            return -1;
            throw new IllegalArgumentException("参数非法：负数（" + n + "）不能求阶乘");
        }
    }

    /**
     * 对双精度数做一元运算
     *
     * @param operand
     * @param operator
     * @return
     */
    public static double unaryOperation(double operand, UnaryOperator<Double> operator) {
        return operator.apply(operand);
    }

    /**
     * 对双精度数做二元运算
     *
     * @param operand1
     * @param operand2
     * @param operator
     * @return
     */
    public static double binaryOperation(double operand1, double operand2, BinaryOperator<Double> operator) {
        return operator.apply(operand1, operand2);
    }


    /**
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return 商
     */
    public static double divide(double dividend, double divisor) {
        if (divisor != 0) {
            return dividend / divisor;
        } else {
            throw new DividedByZeroException();
        }
    }

}
