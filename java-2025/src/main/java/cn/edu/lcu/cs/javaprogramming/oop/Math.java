package cn.edu.lcu.cs.javaprogramming.oop;

/**
 * <p>数学工具类，演示：</p>
 * <ol>
 * <li>方法重载</li>
 * <li>方法签名</li>
 * <li>类型自动转换</li>
 * <li>可变数量的参数（参数个数在编码时未知）</li>
 * </ol>
 * 2022/3/1 23:52
 *
 * @Author ling
 */
public class Math {

    /**
     * 返回两个整数的和
     *
     * @param x
     * @param y
     * @return 两个整型数值的和
     */
    public static int sum(int x, int y) {
        return x + y;
    }

//    public static int sum(int a, int b) {
//        return a + b;
//    }

    /**
     * 返回两个整数的和
     *
     * @param x
     * @param y
     * @return 两个长整型数值的和
     */
    public static long sum(long x, long y) {
        return x + y;
    }

    /**
     * 返回两个整数的和
     *
     * @param x 操作数1
     * @param y 操作数2
     * @return 两个短整型值的和
     */
    public static short sum(short x, short y) {
        // short + short，结果是int？Why？需要转型
        return (short) (x + y);
    }

    /**
     * <h4>可变数量的整数求和（至少2个操作数）</h4>
     *
     * @param x     操作数1，必需
     * @param y     操作数2，必需
     * @param other 剩余的操作数，0或多个，数量可变。
     * @return 若干操作数的和
     */
    public static int sum(int x, int y, int... other) {
        int result = x + y;

        // 参数other，带省略号，它的实质是一个数组
        // 必须作为参数列表的最后一项
        if (other != null && other.length > 0) {
            for (int operand : other) {
                result += operand;
            }
        }

        return result;
    }

    /**
     * 计算给定整数的阶乘。
     *
     * <p>阶乘是指从 1 乘到该整数的所有正整数的乘积，通常表示为 n!。</p>
     *
     * @param n 要计算阶乘的非负整数
     * @return 返回 n 的阶乘值。如果 n 为 0，返回 1。
     * @throws IllegalArgumentException 如果 n 为负数
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n 必须是非负整数");
        }
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    /**
     * 计算给定整数的阶乘，使用递归技术实现。
     *
     * <p>阶乘是指从 1 乘到该整数的所有正整数的乘积，通常表示为 n!。</p>
     *
     * @param n 要计算阶乘的非负整数
     * @return 返回 n 的阶乘值。如果 n 为 0，返回 1。
     * @throws IllegalArgumentException 如果 n 为负数
     */
    public static int factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n 必须是非负整数");
        }
        if (n == 0 || n == 1) {
            return 1; // 0! = 1
        }
        return n * factorialRecursive(n - 1); // n! = n * (n-1)!
    }
}