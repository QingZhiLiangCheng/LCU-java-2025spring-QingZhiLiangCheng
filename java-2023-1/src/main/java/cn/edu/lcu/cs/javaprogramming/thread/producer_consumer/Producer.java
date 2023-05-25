package cn.edu.lcu.cs.javaprogramming.thread.producer_consumer;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 生产者线程类，
 *
 * @author ling
 * @date 2022/5/30 22:28
 */
public class Producer implements Runnable {
    /**
     * 带原子操作的、可自动更新的Long类型，用于生成ID序列。
     */
    private final AtomicLong idSequence = new AtomicLong();
    /**
     * 可阻塞的队列：线程在队列满时进队列、队列空时出队列，会自动挂起线程。
     */
    private final BlockingQueue<Product> queue;

    public Producer(BlockingQueue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Product product = produce();
                // 生产一个数据，并插入队列
                // 如果队列满，当前线程被阻塞，这是由BlockingQueue自动完成的。
                queue.put(product);
                System.out.println(Thread.currentThread().getName() + " 生产了产品 " + product + "\tqueue.size() = " + queue.size());
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生产产品
     *
     * @return
     */
    private Product produce() {
        Product product = Product.builder()
                // ID序列递增并返回，原子操作，防止修改值时被其它线程抢占。
                .id(idSequence.incrementAndGet())
                .productName("product-" + UUID.randomUUID().toString())
                .unitPrice(new Random().nextInt(1000))
                .build();
        return product;
    }
}
