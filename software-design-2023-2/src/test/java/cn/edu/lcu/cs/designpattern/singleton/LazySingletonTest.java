package cn.edu.lcu.cs.designpattern.singleton;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LazySingletonTest {
    /**
     * 多线程测试：开多个线程，同时调用，测试是否线程安全。
     * 懒汉单例模式，线程不安全，可能会产生不同的实例。
     */
    @Test
    void testMultithread() {
        // 循环多次，每次循环开一个线程
        for (int i = 0; i < 10; i++) {
            // 创建匿名内部类线程，实例化，并启动
            new Thread() {
                public void run() {
                    // 获取单例模式的实例并打印到控制台
                    System.out.println(LazySingleton.getInstance());
                }
            }.start();
        }
    }

    @Test
    void testMultithreadWithSet() {
        Set<LazySingleton> singletons = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    singletons.add(LazySingleton.getInstance());
                }
            }.start();
        }
        // 测试会失败，因为下边测试行运行时线程还没有执行，线程池是空的
        // assertTrue(singletons.size() > 1);

        // 测试成功
        assertTrue(singletons.isEmpty());
    }

    @Test
    void equals() {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        if (instance1 == instance2) {
            System.out.println("两个引用指向同一个实例");
        } else {
            System.out.println("两个实例不同");
        }
    }

}