package cn.edu.lcu.cs.designpattern.singleton;

/**
 * 加锁的懒汉单例模式
 */
public class LockedLazySingleton {
    // 构造方法私有，不允许外部直接创建对象
    private LockedLazySingleton() {
    }

    private static LockedLazySingleton instance;

    /**
     * Export一个静态方法，供外部获取这个唯一的实例
     * 懒汉单例模式，线程不安全，多线程并发访问可能会产生不同的实例。
     * 解决办法1：在方法上加锁synchronized
     * 方法调用时被锁定，其它访问本方法的线程阻塞，等待锁被释放。
     * 从根本上保证不可能多个线程同时执行本方法而创建多个实例。
     */
    synchronized public static LockedLazySingleton getInstance() {
        if (instance == null) {
            // 仅在初始阶段的极少数情况下，才会执行到本分支
            // 锁加在方法上，频繁调用，其它进程频繁阻塞，效率低下。
            instance = new LockedLazySingleton();
        }
        return instance;
    }

    /**
     * Export一个静态方法，供外部获取这个唯一的实例
     * 懒汉单例模式，线程不安全，多线程并发访问可能会产生不同的实例。
     * 解决办法2：在方法里边加锁。
     */
    public static LockedLazySingleton getInstance2() {
        if (instance == null) {
            // 仅在初始阶段的极少数情况下，才会执行到本分支
            // 将加锁操作推迟到最后一刻，懒到无话可说。
            synchronized (LockedLazySingleton.class) {
                if (instance == null) {
                    // 在最后时刻再做一次判断，确认一下。
                    // 确实仍为空，再创建实例
                    instance = new LockedLazySingleton();
                }
            }
        }
        return instance;
    }

    // 另外的一些方法
    public void operation() {
    }
}
