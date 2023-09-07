package cn.edu.lcu.cs.designpattern.strategy.log;

/**
 * 日志上下文环境
 */
public class LogContext {
    private LogStrategy strategy;

    public void log(String message) {
        // 默认日志策略：输出到数据库
        strategy = new DbLog();
        try {
            // 日志输出到数据库时可能会发生异常
            strategy.log(message);
        } catch (Exception e) {
            // 如果日志写数据库时发生了异常
            // 打印错误信息
            System.out.println(e.getMessage());
            // 启用容错机制，创建文件日志
            // 因为采用策略模式，换个策略非常方便
            strategy = new FileLog();
            // 将日志输出到文件
            strategy.log(message);
        }
    }
}
