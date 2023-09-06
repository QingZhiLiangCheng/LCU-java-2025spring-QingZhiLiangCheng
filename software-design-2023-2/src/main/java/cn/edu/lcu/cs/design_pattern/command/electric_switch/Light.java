package cn.edu.lcu.cs.design_pattern.command.electric_switch;

/**
 * @description: 电灯类，命令接受者
 * @author: ling
 * @since: 2021-10-11 21:05
 **/
public class Light {
    /**
     * 发光
     */
    public void shine() {
        System.out.println("电灯亮了");
    }

    /**
     * 熄灭
     */
    public void extinguish() {
        System.out.println("电灯关上了");
    }
}
