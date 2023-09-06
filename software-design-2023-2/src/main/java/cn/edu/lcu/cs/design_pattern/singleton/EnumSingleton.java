package cn.edu.lcu.cs.design_pattern.singleton;

/**
 * 用枚举实现的单例模式，单例模式的最佳方法。
 * 避免多线程同步问题，且防止反序列化重新创建对象。
 */
public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("hello, singleton.");
    }
}
