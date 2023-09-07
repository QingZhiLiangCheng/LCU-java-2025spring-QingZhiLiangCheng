package cn.edu.lcu.cs.designpattern.command.undo_redo;

/**
 * 除法命令
 *
 * @Author Ling
 * @Date 2021/10/14 20:42
 * @Version 1.0
 */
public class DivCmd extends Command {

    public DivCmd(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    public double execute() {
        return operand1 / operand2;
    }

}
