package cn.edu.lcu.cs.design_pattern.mediator.relaymessage;

/**
 * 中介者
 */
public interface Mediator {
    /**
     * 职员登记注册
     *
     * @param staff
     */
    void register(Staff staff);

    /**
     * 转发广播消息
     *
     * @param sender
     * @param message
     */
    void relay(Staff sender, String message);

    /**
     * 给指定的接收者转发消息
     *
     * @param sender
     * @param receiver
     * @param message
     */
    void relay(Staff sender, Staff receiver, String message);
}
