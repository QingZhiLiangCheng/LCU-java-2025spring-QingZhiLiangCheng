package cn.edu.lcu.cs.designpattern.mediator.theory;

public interface Mediator {
    /**
     * 向中介者登记注册
     *
     * @param collegue
     */
    void register(Collegue collegue);

    /**
     * 广播消息给所有人
     *
     * @param sender 消息的最初来源，中介者不转发消息给这个对象。
     */
    void relay(Collegue sender);
}
