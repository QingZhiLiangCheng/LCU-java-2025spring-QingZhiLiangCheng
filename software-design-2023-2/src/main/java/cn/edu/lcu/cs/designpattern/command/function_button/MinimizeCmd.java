package cn.edu.lcu.cs.designpattern.command.function_button;

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
