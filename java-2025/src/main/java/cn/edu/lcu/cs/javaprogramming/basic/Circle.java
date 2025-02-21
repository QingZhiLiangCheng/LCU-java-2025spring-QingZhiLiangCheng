package cn.edu.lcu.cs.javaprogramming.basic;

public class Circle {
    /**
     * 常量（常变量）PI，常量名应该全大写，多个单词间加下划线。
     */
    public static final double PI = 3.14159;

    public static void main(String[] args) {
        // 求圆的面积
        double radius = 2;
        // 类似pi这样的数学常量，不能采用变量形式
        //double pi = 3.14;
        //double area = pi * radius * radius;

        double area = PI * radius * radius;
        System.out.printf("半径为%.2f的圆面积是%f", radius, area);
    }
}
