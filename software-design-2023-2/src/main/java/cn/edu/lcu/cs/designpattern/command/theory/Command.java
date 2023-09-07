package cn.edu.lcu.cs.designpattern.command.theory;

/**
 * 命令对象
 */
public interface Command {
    /**
     * 执行命令。不同的命令，执行过程是不同的。
     */
    void execute();

}
