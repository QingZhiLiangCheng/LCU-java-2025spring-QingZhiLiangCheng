package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

/**
 * 外部类
 */
public class Outer {
    private String something = "外部类中定义的一个字符串";

    public void print() {
        System.out.println("外部类的打印\t" + something);

        {
            // 局部内部类，只属于方法或代码块
            class LocalInnerClass {
                private String something = "局部内部中定义的一个字符串";

            }
        }
    }

    /**
     * 内部类
     */
    public class Inner {

        private String something = "内部类中定义的一个字符串";

        public void print() {
            System.out.println("内部类的打印\t" + something);
        }
    }

}
