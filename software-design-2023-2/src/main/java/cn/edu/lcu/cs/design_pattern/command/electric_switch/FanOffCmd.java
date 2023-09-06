package cn.edu.lcu.cs.design_pattern.command.electric_switch;

public class FanOffCmd implements Command {
    private Fan fan;

    public FanOffCmd(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }
}
