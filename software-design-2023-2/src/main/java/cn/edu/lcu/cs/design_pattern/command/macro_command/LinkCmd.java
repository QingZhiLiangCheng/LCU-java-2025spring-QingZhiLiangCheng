package cn.edu.lcu.cs.design_pattern.command.macro_command;

/**
 * 链接命令，将二进制目标文件与库文件链接为可执行文件
 * @author: ling
 * @since: 2021-10-13 21:12
 **/
public class LinkCmd implements Command {
    private Linker linker;

    public LinkCmd() {
        linker = new Linker();
    }

    @Override
    public void execute() {
        linker.link();
    }
}
