package cn.edu.lcu.cs.javaprogramming.thread;

public class MyCounterThreadDaemon extends Thread {
    private static final int MAX = 78;
    private int count = 0;

    @Override
    public void run() {
        while (count < MAX) {
            System.out.println(Thread.currentThread().getName() + "\t" + count++);
        }
    }


    public static void main(String[] args) {
        MyCounterThreadDaemon thread1 = new MyCounterThreadDaemon();
        // 线程有两种：精灵线程（守护线程）与用户线程
        // 当进程的所有用户线程结束之后，进程就结束，不管还有没有精灵线程
        thread1.setDaemon(true);
        thread1.start();

        MyCounterThreadDaemon thread2 = new MyCounterThreadDaemon();
        thread2.setDaemon(true);
        thread2.start();

        System.out.println(Thread.currentThread().getName());
    }
}
