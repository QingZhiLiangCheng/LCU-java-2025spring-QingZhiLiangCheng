package cn.edu.lcu.cs.javaprogramming.thread;

public class MyCounterThread extends Thread {
    private static final int MAX = 78;
    private int count = 0;

    @Override
    public void run() {
        while (count < MAX) {
            System.out.println(Thread.currentThread().getName() + "\t" + count++);
        }
    }


    public static void main(String[] args) {
        new MyCounterThread().start();
        new MyCounterThread().start();

        System.out.println(Thread.currentThread().getName());
    }
}
