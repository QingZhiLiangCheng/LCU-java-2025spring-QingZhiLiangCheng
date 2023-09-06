package cn.edu.lcu.cs.design_pattern.command.electric_switch;

public class FanOnCmd implements Command {
    private Fan fan;

    public FanOnCmd(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }
}
