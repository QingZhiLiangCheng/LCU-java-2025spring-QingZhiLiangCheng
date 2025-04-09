package cn.edu.lcu.cs.qingzhilicangcheng.java2025spring.lecture06.innerclass;

/**
 * 内部类演示
 *
 * @author ling
 * @date 2022/3/22 22:02
 */
public class Outer {
    private String some = "外部类中定义的一个串";
    private String someOfOutter = "外部类独有的串";


    public void print() {
        // 输出本类定义的一个字段
        System.out.println(some);

        // 外部类访问内部类中重名的字段？？
        System.out.println(new Inner().some);

        // 局部内部类，作用域仅限于当前方法的内部
        // 局部内部类可以访问当前方法的局部变量
        // 当前方法也可以访问局部内部类的成员
        class LocalInner {
            private String some = "局部内部类中的一个串";

            public void print() {
                System.out.println(some);
            }
        }
        LocalInner localInner = new LocalInner();
        localInner.print();
    }

    // 定义一个成员内部类
    public class Inner {
        private String some = "内部类中定义的串";

        public void print() {
            // 打印本类（内部类）的字段
            System.out.println(some);

            // 内部类中访问外部类中重名的成员？？？
            // 即使对方是私有的，也可以任性访问
            System.out.println(Outer.this.some);

            // 内部类可以直接访问外部类中的非重名的字段
            System.out.println(someOfOutter);
        }
    }
}