package cn.edu.lcu.cs.design_pattern.singleton;

import java.io.Serializable;

/**
 * 安全的单例模式，不会被序列化或反射破解。
 *
 * @author ling
 */
public class SafeSingleton implements Serializable {
    // 构造方法私有，不允许外部直接创建对象
    private SafeSingleton() {
        // 为了防止反射对单例的破坏
        if (instance != null) {
            throw new RuntimeException("已经创建了实例");
        }
    }

    /**
     * 声明字段之后，立即创建实例并赋值。
     * 太饿了，等不及了。
     * private，防止被外部直接访问。
     * static，参见getInstance()方法。
     */
    private static SafeSingleton instance = new SafeSingleton();

    /**
     * 把创建并保存的实例暴露出去，供外部使用。
     * 必须是static，静态的类方法，通过类名访问。
     * 不然呢？好好琢磨琢磨。
     *
     * @return 创建好的唯一实例
     */
    public static SafeSingleton getInstance() {
        // 静态方法只能直接访问静态字段，所以instance字段必须是静态的。
        return instance;
    }

    /**
     * 解决序列化破坏单例的情况
     *
     * @return
     */
    private Object readResolve() {
        return instance;
    }

    // 另外的一些方法
    public void operation() {
    }
}
