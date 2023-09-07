package cn.edu.lcu.cs.designpattern.bridge.log_bridged;

import java.time.LocalDateTime;

/**
 * @Description 纯文本格式化器
 * @Author Ling
 * @Date 2021/9/28 23:37
 * @Version 1.0
 */
public class HtmlTextLogFormatter implements LogMsgFormatter {

    @Override
    public String format(Logger.LoggerLevel level, String msg) {
        StringBuffer sb = new StringBuffer();
        sb.append("<div>")
                .append("<h3 class='" + level.toString().toLowerCase() + "'>" + LocalDateTime.now() + "</h3>")
                .append("<p>" + msg + "</p>")
                .append("</div>");
        return sb.toString();
    }
}
