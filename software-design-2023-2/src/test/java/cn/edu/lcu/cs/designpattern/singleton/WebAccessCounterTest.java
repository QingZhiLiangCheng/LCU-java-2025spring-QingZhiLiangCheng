package cn.edu.lcu.cs.designpattern.singleton;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * @author ling
 * @date 2022/11/26 13:24
 */
class WebAccessCounterTest {

    @RepeatedTest(10)
    void getInstance() {
        WebAccessCounter instance = WebAccessCounter.getInstance();
        System.out.println("instance = " + instance);
    }

    @Test
    void multithreadTest() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("WebAccessCounter.getInstance() = " + WebAccessCounter.getInstance());
            }).start();
        }
    }
}