package cn.edu.lcu.cs.design_pattern.command.macro_command;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 宏命令，是按顺序执行的一组命令的集合
 * @author: ling
 * @since: 2021-10-13 21:21
 **/
public class MacroCmd implements Command {
    private Queue<Command> commands = new ArrayDeque<>();

    /**
     * 向宏命令队列中追加命令。
     * 因为有些客户需要自定义宏命令，所以公开这个方法。
     *
     * @param command
     */
    public void append(Command command) {
        commands.offer(command);
    }

    @Override
    public void execute() {
        // 依次执行命令队列中的所有命令
        commands.forEach(Command::execute);
//        commands.forEach(command -> command.execute());
    }
}
