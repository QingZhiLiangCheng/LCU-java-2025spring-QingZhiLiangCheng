package cn.edu.lcu.cs.designpattern.command.function_button;

public class FunctionButton {
    private Command command;

    public FunctionButton(Command command) {
        this.command = command;
    }

    public FunctionButton() {
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onClick() {
        command.execute();
    }
}
