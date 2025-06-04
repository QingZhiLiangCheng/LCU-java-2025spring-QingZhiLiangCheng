package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.io;

import java.io.IOException;

public class LoggerDemo {
    public static void main(String[] args) {
        Logger logger = new Logger("test_log.txt");
        System.out.println("logger.LogFileAbsolutePath() = " + logger.getLogFileAbsolutePath());

        try {
            logger.log(Logger.Level.INFO, "用户登录成功");
            logger.log(Logger.Level.WARN, "内存使用过高");
            logger.log(Logger.Level.ERROR, "数据库连接失败");
            logger.log(Logger.Level.DEBUG, "调试信息");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
