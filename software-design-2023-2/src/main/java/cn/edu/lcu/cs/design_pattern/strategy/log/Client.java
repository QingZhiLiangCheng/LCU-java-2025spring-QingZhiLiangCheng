package cn.edu.lcu.cs.design_pattern.strategy.log;

public class Client {
    public static void main(String[] args) {
        LogContext log = new LogContext();
        int length = 5;
        for (int i = 0; i < length; i++) {
            log.log("记录日志" + i);
        }
    }
}
