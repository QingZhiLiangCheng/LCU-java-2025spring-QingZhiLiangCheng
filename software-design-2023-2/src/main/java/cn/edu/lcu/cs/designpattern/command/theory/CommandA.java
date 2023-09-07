package cn.edu.lcu.cs.designpattern.command.theory;

/**
 * 特定的一个具体命令，有特定的执行流程。
 * 它可能依赖一个或多个命令接收者。
 */
public class CommandA implements Command {
    /**
     * 本命令的接收者，即命令的实际执行者。
     * 一个命令对象可以有一个或多个接收者协作执行。
     */
    private Receiver receiver;

    public CommandA() {
        this.receiver = new Receiver();
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 通过调用某些接收者的某些方法实现本命令
     */
    @Override
    public void execute() {
        receiver.action1();
    }
}
