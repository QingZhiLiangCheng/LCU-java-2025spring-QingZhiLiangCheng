package cn.edu.lcu.cs.design_pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 网站访问计数器，线程安全的单例模式。
 * 用AtomicLong实现计数。
 *
 * @author ling
 */

public class AccessCounterWithAtomicLong {
    private AtomicLong cnt;

    private static AccessCounterWithAtomicLong instance = new AccessCounterWithAtomicLong();

    private AccessCounterWithAtomicLong() {
        cnt = new AtomicLong(0);
    }

    public long getCnt() {
        return cnt.longValue();
    }

    public static AccessCounterWithAtomicLong getInstance() {
        return instance;
    }

    /**
     * 因为AtomicLong本身就保证原子操作，方法上不用加锁了。
     */
    public /*synchronized*/ long access() {
        return cnt.incrementAndGet();
    }
}
