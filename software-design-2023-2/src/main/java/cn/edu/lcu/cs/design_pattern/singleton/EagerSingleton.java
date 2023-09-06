package cn.edu.lcu.cs.design_pattern.singleton;

import java.io.Serializable;

/**
 * 饿汉单例模式
 *
 * @author ling
 */
public class EagerSingleton implements Serializable {
    // 构造方法私有，不允许外部直接创建对象
    private EagerSingleton() {
    }

    /**
     * 声明字段之后，立即创建实例并赋值。
     * 太饿了，等不及了。
     * private，防止被外部直接访问。
     * static，参见getInstance()方法。
     */
    private static EagerSingleton instance = new EagerSingleton();

    /**
     * 把创建并保存的实例暴露出去，供外部使用。
     * 必须是static，静态的类方法，通过类名访问。
     * 不然呢？好好琢磨琢磨。
     *
     * @return 创建好的唯一实例
     */
    public static EagerSingleton getInstance() {
        // 静态方法只能直接访问静态字段，所以instance字段必须是静态的。
        return instance;
    }

    // 另外的一些方法
    public void operation() {
    }
}
