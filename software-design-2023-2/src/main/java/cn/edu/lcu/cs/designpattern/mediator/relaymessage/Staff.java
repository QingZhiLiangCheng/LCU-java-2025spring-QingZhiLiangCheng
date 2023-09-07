package cn.edu.lcu.cs.designpattern.mediator.relaymessage;

/**
 * 职工基类
 */
public abstract class Staff {
    private String name;

    protected Mediator mediator;

    public String getName() {
        return name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public Staff(String name) {
        this.name = name;
    }

    /**
     * 接收广播消息
     *
     * @param message
     */
    public void receive(String message) {
        System.out.println("【" + this.getClass().getSimpleName() + "：" + getName() + "】收到了广播消息【" + message + "】");
    }

    /**
     * 接收指定职员的消息
     *
     * @param sender 消息发送者
     * @param message 消息内容
     */
    public void receive(Staff sender, String message) {
        System.out.println("【" + this.getClass().getSimpleName() + "：" + getName() + "】收到了【" + sender.getClass().getSimpleName() + "：" + sender.getName() + "】发来的消息【" + message + "】");
    }

    /**
     * 给指定的同事发送消息
     *
     * @param receiver 消息接收者
     * @param message 消息内容
     */
    public void send(Staff receiver, String message) {
        mediator.relay(this, receiver, message);
    }

    public void send(String message) {
        mediator.relay(this, message);
    }
}
