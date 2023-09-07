package cn.edu.lcu.cs.designpattern.command.theory;

public class CommandB implements Command {
    private Receiver receiver;

    public CommandB() {
        this.receiver = new Receiver();
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action2();
    }
}
