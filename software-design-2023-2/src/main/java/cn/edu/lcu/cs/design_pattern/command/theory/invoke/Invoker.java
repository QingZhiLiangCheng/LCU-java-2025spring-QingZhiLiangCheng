package cn.edu.lcu.cs.design_pattern.command.theory.invoke;

/**
 * 调用者，与接收者耦合。
 */
public class Invoker {
    private Receiver receiver;

    public Invoker(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 调用（执行）命令对象
     */
    public void call() {
        receiver.action();
    }
}
