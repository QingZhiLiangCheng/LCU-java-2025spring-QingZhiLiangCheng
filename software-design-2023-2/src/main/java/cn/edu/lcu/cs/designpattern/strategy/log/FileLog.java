package cn.edu.lcu.cs.designpattern.strategy.log;

import java.time.Instant;

/**
 * 把日志记录到文件
 */
public class FileLog implements LogStrategy {
    @Override
    public void log(String message) {
        System.out.println("日志存入文件");
        System.err.println(Instant.now() + "\t" + message);
    }
}
