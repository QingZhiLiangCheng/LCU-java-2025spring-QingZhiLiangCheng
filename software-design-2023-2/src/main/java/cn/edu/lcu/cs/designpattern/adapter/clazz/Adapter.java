package cn.edu.lcu.cs.designpattern.adapter.clazz;

/**
 * 类适配器模式中的适配器类
 * 继承自被适配类，实现了目标接口
 */

public class Adapter extends Adaptee implements Target {
    @Override
    public void operation2() {
        System.out.println("Method in adapter.");
    }
}
