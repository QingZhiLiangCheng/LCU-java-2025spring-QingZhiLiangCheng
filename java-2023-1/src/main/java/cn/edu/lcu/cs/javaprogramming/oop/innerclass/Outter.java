package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

/**
 * 外部类
 */
public class Outter {
    private String something = "外部类中定义的一个字符串";

    public void print() {
        System.out.println("外部类的打印\t" + something);
    }

}
