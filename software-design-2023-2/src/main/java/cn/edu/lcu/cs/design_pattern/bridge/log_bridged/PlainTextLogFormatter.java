package cn.edu.lcu.cs.design_pattern.bridge.log_bridged;

import java.time.LocalDateTime;

/**
 * @Description 纯文本格式化器
 * @Author Ling
 * @Date 2021/9/28 23:37
 * @Version 1.0
 */
public class PlainTextLogFormatter implements LogMsgFormatter {

    @Override
    public String format(Logger.LoggerLevel level, String msg) {
        return LocalDateTime.now() + "\t" + level + "\t" + msg;
    }
}
