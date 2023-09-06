package cn.edu.lcu.cs.design_pattern.command.function_button;

public class MinimizeCmd implements Command {
    private DisplayFuntion displayFuntion;

    public MinimizeCmd() {
        displayFuntion = new DisplayFuntion();
    }

    @Override
    public void execute() {
        displayFuntion.minimize();
    }
}
