package cn.edu.lcu.cs.designpattern.strategy.log;

public interface LogStrategy {
    /**
     * 记录日志
     * @param message
     */
    public void log(String message);
}
