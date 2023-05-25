package cn.edu.lcu.cs.javaprogramming.thread;

public class MyCounterRunnableLocal implements Runnable {
    private static final int MAX = 78;
    private ThreadLocal<Integer> counter = new ThreadLocal<Integer>();

    @Override
    public void run() {
        if (counter.get() == null) {
            counter.set(0);
        }
        while (counter.get() < MAX) {
            System.out.println(Thread.currentThread().getName() + "\t" + counter.get());
            counter.set(counter.get() + 1);
        }
    }


    public static void main(String[] args) {
        MyCounterRunnableLocal task = new MyCounterRunnableLocal();
        new Thread(task).start();
        new Thread(task).start();

        System.out.println(Thread.currentThread().getName());
    }
}
