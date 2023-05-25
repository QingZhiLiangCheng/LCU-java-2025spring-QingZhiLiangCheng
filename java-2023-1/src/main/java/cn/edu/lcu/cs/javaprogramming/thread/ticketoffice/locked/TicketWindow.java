package cn.edu.lcu.cs.javaprogramming.thread.ticketoffice.locked;

import java.util.Random;

/**
 * 售票窗口线程
 */
public class TicketWindow implements Runnable{
    /**
     * 余票数量，所有窗口线程共享
     */
    private int remainingTicket;
    /**
     * 任意一种类型的实例均可，这是一把锁。
     */
    private Object lock = new Object();

    public TicketWindow(int remainingTicket) {
        this.remainingTicket = remainingTicket;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        // 如果有余票，就销售
        while (remainingTicket > 0) {
            // 每销售一张车票，随机休息一会儿
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 在代码块上加锁，确保绝对安全
            synchronized (lock) {
                // 在售票之前的最后一刻，再次确认余票
                // 可以排除大多数的不安全情况
                if (remainingTicket > 0) {
                    // 售票并输出
                    String message = name + " 销售了 " + remainingTicket-- + " 号车票";
                    System.out.println(message);
                }
            }
        }
        System.err.println(name + " 售票结束");
    }
}
