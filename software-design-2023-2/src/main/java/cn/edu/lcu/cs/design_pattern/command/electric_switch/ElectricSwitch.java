package cn.edu.lcu.cs.design_pattern.command.electric_switch;

/**
 * @description: 用命令模式演示电灯开关。
 * 在命令模式中，命令的发送者【电器开关】与命令的接收者【有可能是灯，也可能是其它电器】解耦，所以再用LightSwitch这个名称不合适了。
 * @author: ling
 * @since: 2021-10-11 21:06
 **/
public class ElectricSwitch {
    /**
     * 命令模式中，命令接收者与命令发送者解耦，所以不必再聚合电灯对象。
     */
//    private Light light;

    /**
     * 开关只与命令对象耦合，它不关心命令那头是什么电器，及对这个电器做什么样的操作。
     */
    private Command command;

    public ElectricSwitch(Command command) {
        this.command = command;
    }

    public ElectricSwitch() {
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

    // 因为无法确定与电器开关控制的是哪个电器，所以开灯、关灯操作就不需要了。
//    public void turnOn() {
//    }
//
//    public void turnOff() {
//    }
}
