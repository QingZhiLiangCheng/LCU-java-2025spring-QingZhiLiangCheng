package cn.edu.lcu.cs.designpattern.singleton;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class StaticAccessCounterTest {
    /**
     * 单线程测试，总是安全的
     */
    @RepeatedTest(100)
    void access() {
        long cnt = StaticAccessCounter.access();
        System.out.println(cnt);
    }

    /**
     * 多线程测试。如果设计不合理，可能发生线程同步问题，输出可能与预期不同。
     */
    @Test
    void multiThreadAccess() {
        int length = 20;
        for (int i = 0; i < length; i++) {
            new Thread(() -> {
                long cnt = StaticAccessCounter.access();
                System.out.print(cnt + "\t");
            }).start();
        }
    }
}