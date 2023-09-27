package cn.edu.lcu.cs.designpattern.singleton;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EagerSingletonTest {

//    @Test
    @RepeatedTest(100)
    void getInstance() {
//        for (int i = 0; i <100; i++) {
            System.out.println("EagerSingleton.getInstance() = " + EagerSingleton.getInstance());
//        }
    }

    /**
     * 饿汉模式，是线程安全的
     */
    @Test
    void multithreadTest() {
        int count = 100;
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(EagerSingleton.getInstance());
                }
            }).start();
        }
    }
}