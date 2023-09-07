package cn.edu.lcu.cs.designpattern.facade.smart_house;

/**
 * @Description 智能家居门面类
 * @Author Ling
 * @Date 2021/9/21 22:07
 * @Version 1.0
 */
public class SmartHouseFacade {
    private Light light;
    private TV tv;
    private AirCondition airCondition;

    /**
     * 门面模式，尽量屏蔽底层的细节，所以在它的构造方法中，直接设置好所依赖的资源。
     */
    public SmartHouseFacade() {
        this.light = new Light();
        this.tv = new TV();
        this.airCondition = new AirCondition();
    }

    /**
     * 一键进入睡眠状态
     */
    public void oneKeySleep() {
        tv.turnOff();
        airCondition.sleepMode();
        light.off();
    }

    /**
     * 出门：关电视，关空调，关灯，……
     */
    public void goOutside() {
        tv.turnOff();
        airCondition.powerOff();
        light.off();
    }

    /**
     * 回家：开电视，开空调，开灯，……
     */
    public void goHome() {
        tv.turnOn();
        airCondition.powerOn();
        light.on();
    }


}
