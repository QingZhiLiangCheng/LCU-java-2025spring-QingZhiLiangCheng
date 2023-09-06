package cn.edu.lcu.cs.architecture.pipe.number_filter;

import cn.edu.lcu.cs.util.ConsoleColor;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 数据过滤器，对读取的数值加上100再输出
 */
public class AddNumberFilter extends Thread {
    private PipedWriter writer; // 写下游管道
    private PipedReader reader; // 读上游管道，输入管道可以设置缓冲区大小

    public AddNumberFilter(PipedWriter writer, PipedReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 从管道中读取一个数
                int num = reader.read();
                // 如果读取到-1，说明上游管道已经关闭，本环节的io流都要关闭
                if (num == -1) {
                    reader.close();
                    writer.close();
                    return;
                }
                System.out.print(ConsoleColor.FG_GREEN + "AddNumberFilter读取：" + num);
                num += 100;
                writer.write(num);
                System.out.println(ConsoleColor.FG_GREEN + "\t写入：" + num);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
