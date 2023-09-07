package cn.edu.lcu.cs.designpattern.singleton;

/**
 * 懒汉单例模式
 *
 * @author ling
 */
public class LazySingleton {
    // 构造方法私有，不允许外部直接创建对象
    private LazySingleton() {
    }

    // 这家伙比较懒，先声明一个字段，不着急给它赋值，啥时候火烧眉毛了再创建实例赋值
    private static LazySingleton instance;

    /**
     * 把创建并保存的实例暴露出去，供外部使用。
     * 懒汉单例模式，线程不安全，多线程并发访问可能会产生不同的实例。
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            // 多线程环境中，可能多个线程同时读取instance，均读到了null，
            // 于是都进入这个分支，调用了构造方法，创建了多个实例。
            // 所以说懒汉单例模式可能是线程不安全的。

            // 要交作业了，才发现还没做，赶紧赶紧
            instance = new LazySingleton();
        }
        return instance;
    }

    // 另外的一些方法
    public void operation() {
    }
}
