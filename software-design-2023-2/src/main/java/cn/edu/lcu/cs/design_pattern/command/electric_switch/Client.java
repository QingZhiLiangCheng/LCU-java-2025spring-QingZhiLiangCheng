package cn.edu.lcu.cs.design_pattern.command.electric_switch;

/**
 * @description: 客户端代码
 * 可以非常方便与不同的命令绑定
 * @author: ling
 * @since: 2021-10-11 21:09
 **/
public class Client {
    public static void main(String[] args) {
        ElectricSwitch electricSwitch;
        Light light = new Light();
        electricSwitch = new ElectricSwitch(new LightOnCmd(light));
        electricSwitch.execute();

        electricSwitch.setCommand(new LightOffCmd(light));
        electricSwitch.execute();

        electricSwitch.setCommand(new MineBombCmd(new Mine()));
        electricSwitch.execute();
    }
}
