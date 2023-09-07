package cn.edu.lcu.cs.designpattern.bridge.log_bridged;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author Ling
 * @Date 2021/9/28 21:02
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        String msg = "一些日志消息some log msg";

        Logger consoleLogger = new ConsoleLogger(new PlainTextLogFormatter());
        consoleLogger.debug(msg);
        consoleLogger.error(msg);

        Logger consoleLogger2 = new ConsoleLogger(new HtmlTextLogFormatter());
        consoleLogger2.debug(msg);
        consoleLogger2.error(msg);

        Logger consoleLogger3 = new ConsoleLogger(new Base64EncryptLogFormatter());
        consoleLogger3.debug(msg);
        consoleLogger3.error(msg);
        // 密文
        String encypted = "MjAyMS0wOS0yOVQwMDoxODoxOC41MDA2MzY2MDAJREVCVUcJ5LiA5Lqb5pel5b+X5raI5oGvc29tZSBsb2cgbXNn";
        System.err.println(encypted);
        // 解密之后的明文
        String decrypted = new String(Base64.getDecoder().decode(encypted.getBytes(StandardCharsets.UTF_8)));
        System.err.println(decrypted);

        Logger fileLogger = new FileLogger("logger.log", new PlainTextLogFormatter());
        fileLogger.debug(msg);
        fileLogger.info(msg);

        Logger fileLogger2 = new FileLogger("logger.log", new HtmlTextLogFormatter());
        fileLogger2.debug(msg);
        fileLogger2.info(msg);
    }
}
