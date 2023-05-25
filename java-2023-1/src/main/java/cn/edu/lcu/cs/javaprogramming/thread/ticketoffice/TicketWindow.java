package cn.edu.lcu.cs.javaprogramming.thread.ticketoffice;

import java.util.Random;

/**
 * 售票窗口线程
 */
public class TicketWindow implements Runnable{
    /**
     * 余票数量，所有窗口线程共享
     */
    private int remainingTicket;

    public TicketWindow(int remainingTicket) {
        this.remainingTicket = remainingTicket;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        // 如果有余票，就销售
        while (remainingTicket > 0) {
            // 售票并输出
            System.out.println(name + " 销售了 " + remainingTicket-- + " 号车票");
            // 每销售一张车票，随机休息一会儿
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.err.println(name + " 售票结束");
    }
}
