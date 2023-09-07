package cn.edu.lcu.cs.designpattern.command.undo_redo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 计算器类
 *
 * @Author Ling
 * @Date 2021/10/14 20:22
 * @Version 1.0
 */
public class Calculator {
    /**
     * 撤消命令的栈
     */
    private Deque<Command> undoStack = new LinkedList<>();

    /**
     * 恢复命令的栈
     */
    private Deque<Command> redoStack = new LinkedList<>();

    /**
     * 计算器的当前运算结果
     */
    private double result;

    public double getResult() {
        return result;
    }

    /**
     * 撤消刚刚执行的命令
     *
     * @return
     */
    public boolean undo() {
        if (undoStack.isEmpty()) {
            System.out.println("撤消列表为空，无法撤消操作。");
            return false;
        } else {
            // 弹出最后执行的命令
            Command cmd = undoStack.pop();
            // 压入恢复命令栈，以备将来恢复之用
            redoStack.push(cmd);
            // 执行撤消命令并打印结果
            System.out.println("undo = " + cmd.undo());
            return true;
        }
    }

    /**
     * 恢复操作，重新运行刚刚撤消的操作。
     *
     * @return
     */
    public boolean redo() {
        if (redoStack.isEmpty()) {
            System.out.println("恢复列表为空，无法恢复操作。");
            return false;
        } else {
            Command cmd = redoStack.pop();
            undoStack.push(cmd);
            System.out.println("redo = " + cmd.redo());
            return true;
        }
    }

    /**
     * 执行命令并打印
     *
     * @param cmd
     */
    private void execute(Command cmd) {
        // 先将当前命令压栈，以备将来撤消用
        undoStack.push(cmd);
        // 执行命令
        result = cmd.execute();
        System.out.println(" = " + result);
    }

    /**
     * 执行加法操作并打印结果
     *
     * @param operand
     */
    public void add(double operand) {
        System.out.print(result + " + " + operand);
        // 创建新命令并执行，修改当前运算结果
        execute(new AddCmd(result, operand));
    }

    public void sub(double operand) {
        System.out.print(result + " - " + operand);
        execute(new SubCmd(result, operand));
    }

    public void mul(double operand) {
        System.out.print(result + " * " + operand);
        execute(new MulCmd(result, operand));
    }

    public void div(double operand) {
        System.out.print(result + " / " + operand);
        execute(new DivCmd(result, operand));
    }
}
