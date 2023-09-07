package cn.edu.lcu.cs.designpattern.singleton;

/**
 * 网站访问计数器，线程安全的单例模式
 */

public class AccessCounter {
    private long cnt;

    private static AccessCounter instance = new AccessCounter();

    private AccessCounter() {
        cnt = 0;
    }

    public long getCnt() {
        return cnt;
    }

    public static AccessCounter getInstance() {
        return instance;
    }

    /**
     * 如果不加 synchronized ，这个方法是线程不安全的
     */
    public synchronized long access() {
        return ++cnt;
    }
}
