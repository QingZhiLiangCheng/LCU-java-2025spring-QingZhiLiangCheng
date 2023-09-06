package cn.edu.lcu.cs.design_pattern.command.electric_switch;

/**
 * @description:
 * @author: ling
 * @since: 2021-10-11 21:21
 **/
public class LightOffCmd implements Command {
    private Light light;

    public LightOffCmd(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.extinguish();
    }
}
