package cn.edu.lcu.cs.design_pattern.strategy.log;

public interface LogStrategy {
    /**
     * 记录日志
     * @param message
     */
    public void log(String message);
}
