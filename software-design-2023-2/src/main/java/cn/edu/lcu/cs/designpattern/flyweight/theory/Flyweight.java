package cn.edu.lcu.cs.designpattern.flyweight.theory;

/**
 * 抽象享元类，接口或抽象类。
 * 声明享元类公共的方法，可以向外界提供享元对象的内部数据（内部状态）。
 *
 * @author ling
 * @date 2022/9/10 0:07
 */
public interface Flyweight {
    /**
     * 操作外部状态数据的一些方法。
     * 外部状态，是随环境改变而改变的、不可以共享的状态。
     * 享元对象的外部状态通常由客户端保存，需要使用的时候再传入到享元对象内部。
     * 外部状态之间是相互独立的。
     *
     * @param extrinsicState 享元对象的外部状态数据
     */
    void someOperation(String extrinsicState);

    /**
     * 获取内部状态数据。
     * 内部状态，是存储在享元对象内部并且不会随环境改变而改变的状态，内部状态可以共享。
     *
     * @return 内部状态数据
     */
    String getIntrinsicState();
}
