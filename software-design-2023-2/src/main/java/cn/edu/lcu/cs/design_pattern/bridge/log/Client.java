package cn.edu.lcu.cs.design_pattern.bridge.log;


/**
 * @Author Ling
 * @Date 2021/9/28 21:02
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger();
        String msg = "一些日志消息some log msg";
        consoleLogger.debug(msg);
        consoleLogger.error(msg);


        Logger fileLogger = new FileLogger("d:/logger.log");
        fileLogger.debug(msg);
        fileLogger.info(msg);

    }
}
