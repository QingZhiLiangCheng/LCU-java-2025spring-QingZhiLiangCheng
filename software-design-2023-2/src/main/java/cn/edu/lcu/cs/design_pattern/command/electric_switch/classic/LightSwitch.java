package cn.edu.lcu.cs.design_pattern.command.electric_switch.classic;

/**
 * @description: 电灯开关，命令发送者
 * @author: ling
 * @since: 2021-10-11 21:06
 **/
public class LightSwitch {
    /**
     * 命令接收者，与命令发送者紧耦合
     */
    private Light light;

    public LightSwitch(Light light) {
        this.light = light;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public void turnOn() {
        light.shine();
    }

    public void turnOff() {
        light.extinguish();
    }
}
