package cn.edu.lcu.cs.designpattern.bridge.log_bridged;

/**
 * @Description 日志接口
 * @Author Ling
 * @Date 2021/9/28 20:38
 * @Version 1.0
 */
public interface Logger {
    void error(String msg);

    void warn(String msg);

    void info(String msg);

    void debug(String msg);

    void log(LoggerLevel level, String msg);

    /**
     * 日志级别， error > warn > info > debug
     */
    public enum LoggerLevel {
        ERROR, WARN, INFO, DEBUG
    }

}
