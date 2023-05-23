package cn.edu.lcu.cs.javaprogramming.thread;

public class MultiThreadDemo extends Thread{
    public static void main(String[] args) throws InterruptedException {
        MultiThreadDemo thread = new MultiThreadDemo();
        // 线程主方法不能直接调用，否则就是普通的方法调用，还是一个线程。
//        thread.run();

        // 启动一个新线程
        thread.start();
        int i = 0;
        while (true) {
            System.err.println(i++);
            Thread.sleep(500);
        }
    }

    /**
     * 线程主方法
     */
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
