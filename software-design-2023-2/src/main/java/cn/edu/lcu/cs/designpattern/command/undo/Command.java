package cn.edu.lcu.cs.designpattern.command.undo;

public interface Command {
    /**
     * 正常的操作
     *
     * @param value
     * @return 计算器运算之后的最新值
     */
    int execute(int value);

    /**
     * 如果可以撤消，就进行正常操作的逆操作；否则抛出无法撤消的异常。
     *
     * @return 计算器撤消刚才操作之后的最新值
     */
    int undo();

    /**
     * 是否可进行撤消操作
     *
     * @return
     */
    boolean isUndoable();
}
