package cn.edu.lcu.cs.design_pattern.command.undo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 累加命令，聚合了一个累加器对象。
 */
public class AccumulateCmd implements Command {
    private Accumulator accumulator;
    /**
     * 双端队列实现的堆栈，存储所有的操作，用于撤消操作。
     */
    private Deque<Integer> undoStack = new ArrayDeque<>();

    public AccumulateCmd() {
        this.accumulator = new Accumulator();
    }

    @Override
    public int execute(int value) {
        System.out.print("正常累加操作：\t" + accumulator.getResult() + " + " + value + " = ");

        int result = accumulator.accumulate(value);
        undoStack.push(value);

        System.out.println(result);
        return result;
    }

    @Override
    public int undo() {
        if (!undoStack.isEmpty()) {
            int result = accumulator.getResult();
            int value = undoStack.pop();
            System.out.print("撤消累加操作：\t" + result + " - " + value + " = ");
            result = accumulator.accumulate(value * -1);
            System.out.println(result);
            return result;
        } else {
            throw new RuntimeException("没有可撤消的操作。");
        }
    }

    @Override
    public boolean isUndoable() {
        return !undoStack.isEmpty();
    }

    /**
     * 重置操作
     */
    public void reset() {
        accumulator.reset();
        undoStack.clear();
    }
}
