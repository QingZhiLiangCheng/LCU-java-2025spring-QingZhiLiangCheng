package cn.edu.lcu.cs.javaprogramming.thread.producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ling
 * @date 2022/5/30 23:28
 */
public class Process {
    public static void main(String[] args) {
        int capacity = 5;
        // 声明并创建一个指定容量的可阻塞队列
        BlockingQueue<Product> queue = new LinkedBlockingQueue<>(capacity);
        // 生产者、消费者均通过该队列共享数据
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer, "生产者1").start();
        new Thread(producer, "生产者2").start();
        new Thread(producer, "生产者3").start();
        new Thread(consumer, "消费者1").start();
    }
}
