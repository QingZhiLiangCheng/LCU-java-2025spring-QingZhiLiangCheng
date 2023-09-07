package cn.edu.lcu.cs.designpattern.command.temperature_control;

public class FanOffCmd implements Command {
    private Fan fan;

    public FanOffCmd(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.stopRotate();
    }
}
