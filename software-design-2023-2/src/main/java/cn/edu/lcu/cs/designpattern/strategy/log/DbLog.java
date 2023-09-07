package cn.edu.lcu.cs.designpattern.strategy.log;

import java.time.Instant;

/**
 * 把日志记录到数据库
 */
public class DbLog implements LogStrategy {
    @Override
    public void log(String message) {
        // 获取数据库连接，可能会抛出异常
        DBConnection connection = DBConnection.getInstance();
        // …… 使用数据库连接将日志写入数据库，代码略

        System.out.println("日志存入数据库");
        System.err.println(Instant.now() + "\t" + message);
    }
}
