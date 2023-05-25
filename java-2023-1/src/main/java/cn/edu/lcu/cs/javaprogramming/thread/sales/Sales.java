package cn.edu.lcu.cs.javaprogramming.thread.sales;

public class Sales {
    public static void main(String[] args) {
        Salesman lisi = new Salesman("lisi", 10);
        // 启动新线程
        lisi.start();

        new Salesman("zhang", 15).start();
        new Salesman("wang", 15).start();
        new Salesman("zhao", 25).start();
        new Salesman("qian", 15).start();

        for (int i = 100; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
    }
}
