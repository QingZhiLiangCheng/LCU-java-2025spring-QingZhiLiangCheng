package cn.edu.lcu.cs.javaprogramming.thread.sales;

import java.util.Random;

/**
 * 推销员线程，有各自独立的销售任务。
 */
public class Salesman extends Thread {
    /**
     * 销售余额
     */
    private int balance;

    public Salesman(String name, int balance) {
        super(name);
        this.balance = balance;
    }

    @Override
    public void run() {
        // 当前线程的名称，默认是 Thread-n，也可以指定
        // 持续推销，直到结束
        String name = Thread.currentThread().getName();
        while (balance > 0) {
            System.out.println(name + " 销售了第 " + balance-- + " 号商品");
            // 随机休眠2000以内的毫秒
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.err.println(name + " 今天的销售任务结束，可以下班了。");
    }
}
