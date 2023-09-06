package cn.edu.lcu.cs.architecture.pipe.number_filter;

import java.io.IOException;
import java.io.PipedWriter;

import static cn.edu.lcu.cs.util.ConsoleColor.FG_RED;

/**
 * 数据源过滤器，生产数据
 */
public class NumberSource extends Thread {
    private PipedWriter writer;

    public NumberSource(PipedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        int length = 100;
        try {
            for (int i = 0; i < length; i++) {
                // 向管道中写入数据
                writer.write(i);
                System.out.println(FG_RED + "NumberSource写入：" + i);
            }
            // 关闭流，向流中写入 -1（直接写-1，读出的不是-1，而是65535）
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
