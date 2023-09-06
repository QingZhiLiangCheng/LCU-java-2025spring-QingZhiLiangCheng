package cn.edu.lcu.cs.design_pattern.command.temperature_control;

public class FanOnCmd implements Command {
    private Fan fan;

    public FanOnCmd(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.startRotate();
    }
}
