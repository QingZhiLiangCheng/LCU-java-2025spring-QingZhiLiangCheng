package cn.edu.lcu.cs.design_pattern.singleton;

/**
 * @description: 用内部类实现的单例模式，线程安全。
 * @author: ling
 * @since: 2021-08-21 20:42
 **/
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    public static InnerClassSingleton getInstance() {
        // 当第一次调用本方法时，需要访问内部类，于是内部类被加载，内部类中的静态实例被创建，且仅创建一次。
        return SingletonHolder.INSTANCE;
    }

    /**
     * JVM加载外部类时不会自动加载内部类。
     * 当内部类被调用时才会加载内部类。
     * 内部类被加载时，静态属性被初始化。
     */
    private static class SingletonHolder {
        private final static InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }


}
