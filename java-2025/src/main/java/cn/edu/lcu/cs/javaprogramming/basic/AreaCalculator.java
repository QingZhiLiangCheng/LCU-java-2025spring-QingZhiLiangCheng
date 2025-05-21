package cn.edu.lcu.cs.javaprogramming.basic;

/**
 * 提供多种图形的面积计算方法。
 */
public class AreaCalculator {

    /**
     * 计算圆形的面积。
     *
     * @param radius 圆形的半径
     * @return 圆形的面积，等于 π * radius^2
     */
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    /**
     * 计算矩形的面积。
     *
     * @param length 矩形的长度
     * @param width  矩形的宽度
     * @return 矩形的面积，等于 length * width
     */
    public static double calculateArea(double length, double width) {
        return length * width;
    }

    /**
     * 计算三角形的面积。
     *
     * @param base   三角形的底边长度
     * @param height 三角形的高
     * @param type   图形类型，必须为 "triangle"
     * @return 如果类型为三角形，则返回 0.5 * base * height；否则返回 0
     */
    public static double calculateArea(double base, double height, String type) {
        if ("triangle".equalsIgnoreCase(type)) {
            return 0.5 * base * height;
        }
        return 0;
    }

    /**
     * 主方法，用于演示不同图形的面积计算。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("矩形面积: " + AreaCalculator.calculateArea(4.0, 5.0));
        System.out.println("圆形面积: " + AreaCalculator.calculateArea(7.0));
        System.out.println("三角形面积: " + AreaCalculator.calculateArea(3.0, 4.0, "triangle"));
    }
}
