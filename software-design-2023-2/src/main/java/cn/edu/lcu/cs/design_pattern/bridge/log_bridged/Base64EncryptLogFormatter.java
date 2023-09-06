package cn.edu.lcu.cs.design_pattern.bridge.log_bridged;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

/**
 * @Description Base64加密格式化器
 * @Author Ling
 * @Date 2021/9/28 23:37
 * @Version 1.0
 */
public class Base64EncryptLogFormatter implements LogMsgFormatter {

    @Override
    public String format(Logger.LoggerLevel level, String msg) {
        String logMsg = LocalDateTime.now() + "\t" + level + "\t" + msg;
        return Base64.getEncoder().encodeToString(logMsg.getBytes(StandardCharsets.UTF_8));

        // 解密方式
        // String decrypted = new String(Base64.getDecoder().decode(encypted.getBytes(StandardCharsets.UTF_8)));
    }
}
