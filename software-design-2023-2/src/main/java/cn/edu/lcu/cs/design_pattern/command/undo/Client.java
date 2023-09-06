package cn.edu.lcu.cs.design_pattern.command.undo;

public class Client {
    public static void main(String[] args) {
        AccumulateCmd accumulateCmd = new AccumulateCmd();
        Calculator calculator = new Calculator(accumulateCmd);

        calculator.calculate(1); // 计算
        calculator.calculate(2);
        calculator.calculate(-3);
        calculator.undo(); // 撤消
        calculator.calculate(4);
        calculator.calculate(5);
        calculator.undo();
        calculator.undo();
        calculator.undo();
        calculator.undo();
        calculator.undo(); // 所有操作都撤消了，再撤消就抛出异常
    }
}
