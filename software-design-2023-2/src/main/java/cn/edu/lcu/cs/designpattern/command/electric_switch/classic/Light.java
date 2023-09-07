package cn.edu.lcu.cs.designpattern.command.electric_switch.classic;

/**
 * @description: 电灯类，命令接受者
 * @author: ling
 * @since: 2021-10-11 21:05
 **/
public class Light {
    public void shine() {
        System.out.println("电灯亮了");
    }

    public void extinguish() {
        System.out.println("电灯灭了");
    }
}
