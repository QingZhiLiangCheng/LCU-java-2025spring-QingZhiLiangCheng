package cn.edu.lcu.cs.javaprogramming.thread;

import org.junit.jupiter.api.Test;

class MyCounterTest {

    @Test
    void run() throws InterruptedException {
        MyCounterThread counter = new MyCounterThread();
        Thread counter1 = new Thread(counter, "counter1");
        counter1.start();
        Thread counter2 = new Thread(counter, "counter2");
        counter2.start();

        // 当前就是主线程
        // 主线程允许其他线程插队
        counter1.join();
//        counter2.join();
        System.out.println(Thread.currentThread().getName() + " 结束了");
    }

    @Test
    void lambdaThread() {
        new Thread(() -> {
            int count = 84;
            while (count > 0) {
                System.out.println(count--);
            }
        }).start();
    }

    @Test
    void innerclassThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 84;
                while (count > 0) {
                    System.out.println(count--);
                }
            }
        }).start();
    }
}