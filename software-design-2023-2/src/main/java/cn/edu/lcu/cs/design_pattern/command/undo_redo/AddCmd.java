package cn.edu.lcu.cs.design_pattern.command.undo_redo;

/**
 * 加法命令
 *
 * @Author Ling
 * @Date 2021/10/14 20:42
 * @Version 1.0
 */
public class AddCmd extends Command {

    public AddCmd(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    public double execute() {
        return operand1 + operand2;
    }

}
