package cn.edu.lcu.cs.design_pattern.adapter.clazz;

/**
 * 适配者类，既有类
 * 其中某些操作是新接口需要的。
 */
public class Adaptee {
    public void operation1() {
        System.out.println("Method in adaptee.");
    }
}
