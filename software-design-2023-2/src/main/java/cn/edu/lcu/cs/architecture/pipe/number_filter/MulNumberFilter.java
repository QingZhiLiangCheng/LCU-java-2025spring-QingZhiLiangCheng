package cn.edu.lcu.cs.architecture.pipe.number_filter;

import cn.edu.lcu.cs.util.ConsoleColor;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 数据过滤器，对读取的数值乘以2再输出
 */
public class MulNumberFilter extends Thread {
    private PipedWriter writer;
    private PipedReader reader;

    public MulNumberFilter(PipedWriter writer, PipedReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 从管道中读取一个数
                int num = reader.read();
                // 如果读取到结束标志 -1
                if (num == -1) {
                    reader.close();
                    writer.close();
                    return;
                }
                System.out.print(ConsoleColor.FG_YELLOW + "MulNumberFilter读取：" + num);
                num *= 2;
                writer.write(num);
                System.out.println(ConsoleColor.FG_YELLOW + "\t写入：" + num);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
