package cn.edu.lcu.cs.designpattern.singleton;

import org.junit.jupiter.api.Test;

class InnerClassSingletonTest {

    @Test
    void getInstance() {
        // 循环多次，每次循环开一个线程
        for (int i = 0; i < 10; i++) {
            // 创建匿名内部类线程，实例化，并启动
            new Thread() {
                public void run() {
                    // 获取单例模式的实例并打印到控制台
                    System.out.println(InnerClassSingleton.getInstance());
                }
            }.start();
        }
    }

}