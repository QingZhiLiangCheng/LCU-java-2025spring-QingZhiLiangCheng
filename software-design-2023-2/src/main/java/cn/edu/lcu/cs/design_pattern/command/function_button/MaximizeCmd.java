package cn.edu.lcu.cs.design_pattern.command.function_button;

public class MaximizeCmd implements Command {
    private DisplayFuntion displayFuntion;

    public MaximizeCmd() {
        displayFuntion = new DisplayFuntion();
    }

    @Override
    public void execute() {
        displayFuntion.maximize();
    }
}
