package cn.edu.lcu.cs.design_pattern.command.electric_switch.classic;

/**
 * @description:
 * @author: ling
 * @since: 2021-10-11 21:09
 **/
public class Client {
    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch(new Light());

        lightSwitch.turnOn();
        lightSwitch.turnOff();
    }
}
