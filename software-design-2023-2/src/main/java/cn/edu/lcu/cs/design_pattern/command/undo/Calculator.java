package cn.edu.lcu.cs.design_pattern.command.undo;

/**
 * 计算器类，设置不同的命令对象，即可执行不同的运算。
 */
public class Calculator {
    private Command command;

    public Calculator() {
    }

    public Calculator(Command command) {
        this.command = command;
    }

    public int calculate(int value) {
        return command.execute(value);
    }

    public int undo() {
        return command.undo();
    }
}
