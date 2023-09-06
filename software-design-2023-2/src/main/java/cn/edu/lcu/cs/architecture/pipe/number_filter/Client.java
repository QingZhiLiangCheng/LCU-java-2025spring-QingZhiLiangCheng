package cn.edu.lcu.cs.architecture.pipe.number_filter;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Client {
    public static void main(String[] args) throws IOException {
        PipedWriter writer1 = new PipedWriter();
        PipedWriter writer2 = new PipedWriter();
        PipedWriter writer3 = new PipedWriter();

        // 创建一系列指定缓冲区大小的Reader，并与Writer连接
        // 缓冲区设置得这么小，是为了人为产生一些阻塞，方便演示线程的同步问题
        PipedReader reader1 = new PipedReader(writer1, 3);
        PipedReader reader2 = new PipedReader(writer2, 2);
        PipedReader reader3 = new PipedReader(writer3, 4);

        // 创建一系列过滤器，并设置reader与writer
        NumberSource filter1 = new NumberSource(writer1);
        AddNumberFilter filter2 = new AddNumberFilter(writer2, reader1);
        MulNumberFilter filter3 = new MulNumberFilter(writer3, reader2);
        NumberSink filter4 = new NumberSink(reader3);

        filter1.start(); // 依次启动4个过滤器线程
        filter2.start();
        filter3.start();
        filter4.start();

//        filter1.run(); // 线程的run() 不能直接调用
//        filter2.run();
//        filter3.run();
//        filter4.run();

    }
}
