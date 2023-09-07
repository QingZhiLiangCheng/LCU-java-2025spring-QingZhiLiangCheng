package cn.edu.lcu.cs.designpattern.bridge.log;

import java.time.LocalDateTime;

import static cn.edu.lcu.cs.designpattern.bridge.log.Logger.LoggerLevel.*;

/**
 * @Description 控制台日志记录器
 * @Author Ling
 * @Date 2021/9/28 20:45
 * @Version 1.0
 */
public class ConsoleLogger implements Logger {
    @Override
    public void error(String msg) {
        log(ERROR, msg);
    }

    @Override
    public void info(String msg) {
        log(INFO, msg);
    }

    @Override
    public void warn(String msg) {
        log(WARN, msg);
    }

    @Override
    public void debug(String msg) {
        log(DEBUG, msg);
    }

    /**
     * 日志消息的格式固定死了，如果想改变格式，需要修改旧代码，不符合开闭原则。
     *
     * @param level
     * @param msg
     */
    @Override
    public void log(LoggerLevel level, String msg) {
        System.out.println(LocalDateTime.now() + "\t" + level + "\t" + msg);
    }
}
