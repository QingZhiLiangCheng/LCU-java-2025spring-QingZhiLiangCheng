package cn.edu.lcu.cs.javaprogramming.thread;

public class MyCounterRunnable implements Runnable {
    private static final int MAX = 78;
    private int count = 0;

    @Override
    public void run() {
        while (count < MAX) {
            System.out.println(Thread.currentThread().getName() + "\t" + count++);
        }
    }


    public static void main(String[] args) {
        MyCounterRunnable task = new MyCounterRunnable();
        new Thread(task).start();
        new Thread(task).start();

        System.out.println(Thread.currentThread().getName());
    }
}
