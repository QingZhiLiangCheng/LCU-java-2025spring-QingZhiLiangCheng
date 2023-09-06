package cn.edu.lcu.cs.design_pattern.bridge.log_bridged;

/**
 * @Description 日志消息的格式化器
 * @Author Ling
 * @Date 2021/9/28 23:35
 * @Version 1.0
 */
public interface LogMsgFormatter {
    /**
     * 按照某种规则将原始日志消息格式化。
     *
     * @param msg
     * @return
     */
    String format(Logger.LoggerLevel level, String msg);
}
