package cn.edu.lcu.cs.designpattern.singleton;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AccessCounterTest {

    //    @Test
    @RepeatedTest(100)
    void access() {
        AccessCounter counter = AccessCounter.getInstance();
        counter.access();
        System.out.println(counter.getCnt());
    }

    /**
     * 多线程测试
     */
    @Test
    void multiThreadAccess() {
        int length = 100;
        for (int i = 0; i < length; i++) {
            new Thread(() -> {
                AccessCounter counter = AccessCounter.getInstance();
                long cnt = counter.access();
                System.out.print(cnt + "\t");
            }).start();
        }
    }
}