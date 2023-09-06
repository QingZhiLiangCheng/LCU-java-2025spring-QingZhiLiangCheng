package cn.edu.lcu.cs.design_pattern.command.function_button;

public class ExitSystemCmd implements Command {
    private SystemFunction systemFunction;

    public ExitSystemCmd() {
        systemFunction = new SystemFunction();
    }

    @Override
    public void execute() {
        systemFunction.exit();
    }
}
