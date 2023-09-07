package cn.edu.lcu.cs.designpattern.facade.smart_house;

/**
 * @Description 灯具
 * @Author Ling
 * @Date 2021/9/21 22:01
 * @Version 1.0
 */
public class Light {
    private boolean powerStatus;

    public void on() {
        powerStatus = true;
        System.out.println("开灯");
    }

    public void off() {
        powerStatus = false;
        System.out.println("拉灯");
    }

    /**
     * 切换电源状态
     */
    public void switchPower() {
        powerStatus = !powerStatus;
    }


}
