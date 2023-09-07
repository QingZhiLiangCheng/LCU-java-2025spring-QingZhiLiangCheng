package cn.edu.lcu.cs.designpattern.command.theory;

/**
 * 调用者，不与接收者直接耦合，而与命令对象耦合，命令对象再与接收者耦合。
 */
public class Invoker {
    private Command command;

    public Invoker() {
    }

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 调用（执行）命令对象
     */
    public void call() {
        this.command.execute();
    }
}
