package cn.edu.lcu.cs.architecture.pipe.number_filter;

import cn.edu.lcu.cs.util.ConsoleColor;

import java.io.IOException;
import java.io.PipedReader;

/**
 * 数据接收器，收集数据
 */
public class NumberSink extends Thread {
    private PipedReader reader;

    public NumberSink(PipedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 从管道中读取一个数
                int num = reader.read();
                // 如果读取到-1，说明上游输出管道已经关闭了
                if (num == -1) {
                    reader.close();
                    return;
                }
                System.out.println(ConsoleColor.FG_BLUE + "NumberSink读取：" + num);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
