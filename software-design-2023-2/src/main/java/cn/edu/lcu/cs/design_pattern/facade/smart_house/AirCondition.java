package cn.edu.lcu.cs.design_pattern.facade.smart_house;

/**
 * @Description 空调
 * @Author Ling
 * @Date 2021/9/21 22:05
 * @Version 1.0
 */
public class AirCondition {
    private boolean powerStatus;
    /**
     * 当前运行模式，比如睡眠，制冷，制热，等
     */
    private String mode;

    public void powerOn() {
        powerStatus = true;
        System.out.println("打开空调");
    }

    public void powerOff() {
        powerStatus = false;
        System.out.println("关闭空调");
    }

    public void sleepMode() {
        mode = "睡眠";
        System.out.println("进入睡眠模式");
    }
}
