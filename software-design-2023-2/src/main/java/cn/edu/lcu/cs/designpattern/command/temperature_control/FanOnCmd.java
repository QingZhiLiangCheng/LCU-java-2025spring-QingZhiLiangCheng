package cn.edu.lcu.cs.designpattern.command.temperature_control;

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
