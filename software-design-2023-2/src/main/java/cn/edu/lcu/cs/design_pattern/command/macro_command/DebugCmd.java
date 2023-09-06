package cn.edu.lcu.cs.design_pattern.command.macro_command;

/**
 * @description: Debug命令
 * @author: ling
 * @since: 2021-10-13 21:14
 **/
public class DebugCmd implements Command {
    private Debugger debugger;

    public DebugCmd() {
        debugger = new Debugger();
    }

    @Override
    public void execute() {
        debugger.debug();
    }
}
