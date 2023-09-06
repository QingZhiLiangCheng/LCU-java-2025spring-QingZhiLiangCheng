package cn.edu.lcu.cs.design_pattern.command.undo_redo;

/**
 * @Author Ling
 * @Date 2021/10/14 20:40
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(1);
        calculator.sub(2);
        calculator.mul(3);
        calculator.div(4);
        calculator.undo();
        calculator.undo();
        calculator.undo();
        calculator.undo();
        calculator.undo();
        calculator.redo();
        calculator.redo();
        calculator.redo();
        calculator.redo();
    }
}
