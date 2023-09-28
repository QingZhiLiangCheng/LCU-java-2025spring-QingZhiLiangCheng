package cn.edu.lcu.cs.designpattern.singleton;

import org.junit.jupiter.api.Test;

class LockedLazySingletonTest {
    /**
     * 多线程测试：开多个线程，同时调用，测试是否线程安全。
     * 懒汉单例模式，线程不安全，可能会产生不同的实例。
     * 解决办法：加锁
     */
    @Test
    void multithreadTest() {
        for (int i = 0; i < 1000; i++) {
            new Thread() {
                public void run() {
                    System.out.println(LockedLazySingleton.getInstance());
                }
            }.start();
        }
    }

    @Test
    void multithreadTest2() {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    System.out.println(LockedLazySingleton.getInstance2());
                }
            }.start();
        }
    }
}