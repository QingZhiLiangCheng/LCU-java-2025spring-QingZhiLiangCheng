package cn.edu.lcu.cs.design_pattern.command.macro_command;

/**
 * @description: 编译命令
 * @author: ling
 * @since: 2021-10-13 21:11
 **/
public class CompileCmd implements Command {
    private Compiler compiler;

    public CompileCmd() {
        compiler = new Compiler();
    }

    @Override
    public void execute() {
        compiler.compile();
    }
}
