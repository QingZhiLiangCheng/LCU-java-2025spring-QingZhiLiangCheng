package cn.edu.lcu.cs.javaprogramming.util;

/**
 * 数学工具类，演示方法重载、方法递归、可变数量的参数
 *
 * @author Ling
 */
public class MathUtil {
    public static final double PI = 3.14;

    // 求两个整型参数的和并返回
    public static int add(int a, int b) {
        return a + b;
    }

    public static short add(short a, short b) {
        return (short) (a + b);
    }

    public static long add(long a, long b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * 求可变数量的若干个整数的和
     * nums are the number of   elements
     * nums 其实是一个数组
     */
    public static int add(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }


}
