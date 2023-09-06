package cn.edu.lcu.cs.design_pattern.mediator.theory;

public abstract class Collegue {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 接收消息
     */
    public abstract void receive();

    /**
     * 发送消息。此例中没有指定接收者与消息内容。
     */
    public abstract void send();
}
