package cn.edu.lcu.cs.javaprogramming.thread.producer_consumer;

import lombok.extern.java.Log;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者线程类，从队列中取数据进行消费，当队列为空时线程被挂起。
 *
 * @author ling
 * @date 2022/5/30 23:25
 */
@Log
public class Consumer implements Runnable{
    private final BlockingQueue<Product> queue;

    public Consumer(BlockingQueue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 从队列中提取一个数据
                // 如果队列为空，当前线程被阻塞，这是由BlockingQueue自动完成的。
                Product product = queue.take();
                consume(product);
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume(Product product) {
        System.err.println(Thread.currentThread().getName() + " 消费了产品 " + product + "\tqueue.size() = " + queue.size());
    }
}
