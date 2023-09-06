package cn.edu.lcu.cs.design_pattern.command.undo_redo;

public abstract class Command {
    /**
     * 操作数1。
     * 在本例中，操作数1其实就是前次操作的结果。
     */
    protected double operand1;
    /**
     * 操作数2
     */
    protected double operand2;

    public Command(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    /**
     * 执行命令，将两个操作数进行某种二元算术运算
     *
     * @return
     */
    public abstract double execute();

    /**
     * 撤消操作。
     * 各种命令的撤消操作千差万别，视具体情况而定。
     * 本例中，所谓撤消，即是把前次运算的结果（operand1）恢复出来而已，没有复杂的运算。
     *
     * @return
     */
    public double undo() {
        return operand1;
    }

    /**
     * 恢复操作，重新进行一次运算。
     *
     * @return
     */
    public double redo() {
        return execute();
    }
}
