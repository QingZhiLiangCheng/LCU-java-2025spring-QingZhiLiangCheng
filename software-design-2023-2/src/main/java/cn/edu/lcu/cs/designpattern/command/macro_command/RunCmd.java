package cn.edu.lcu.cs.designpattern.command.macro_command;

/**
 * @description: Debug命令
 * @author: ling
 * @since: 2021-10-13 21:14
 **/
public class RunCmd implements Command {
    private Runner runner;

    public RunCmd() {
        runner = new Runner();
    }

    @Override
    public void execute() {
        runner.run();
    }
}
