package cn.edu.lcu.cs.designpattern.command.macro_command;

/**
 * 功能键，可动态设置其对应的功能（命令）
 */
public class FunctionButton {
    private Command command;

    public FunctionButton() {
    }

    public FunctionButton(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 当在功能键上单击时触发执行
     */
    public void onClick() {
        command.execute();
    }
}
