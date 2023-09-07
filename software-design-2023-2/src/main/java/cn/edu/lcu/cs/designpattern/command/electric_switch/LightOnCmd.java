package cn.edu.lcu.cs.designpattern.command.electric_switch;

/**
 * @description:
 * @author: ling
 * @since: 2021-10-11 21:21
 **/
public class LightOnCmd implements Command {
    private Light light;

    public LightOnCmd(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.shine();
    }
}
