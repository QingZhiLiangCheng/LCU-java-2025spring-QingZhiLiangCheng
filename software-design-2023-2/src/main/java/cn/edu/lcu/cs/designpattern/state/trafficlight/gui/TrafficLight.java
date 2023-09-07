package cn.edu.lcu.cs.designpattern.state.trafficlight.gui;

/**
 * 交通灯模拟类，持有状态对象，相当于策略模式中的环境类Context
 */
public class TrafficLight {
    private TrafficState state;
    private int maxCountdown;

    public TrafficLight() {
        // 设置初始状态
        state = new RedState(this);
        maxCountdown = state.countdown;
    }

    /**
     * 心跳计数，如果减到0，就改变颜色状态。
     *
     * @return 颜色状态是否发生了变化
     */
    public boolean change() {
        // 状态改变的策略由状态本身的方法负责
        return state.change();
    }

    public int getCountdown() {
        return state.countdown;
    }

    public int getMaxCountdown() {
        return maxCountdown;
    }

    public String getColor() {
        return state.color;
    }

    public void setState(TrafficState state) {
        this.state = state;
        maxCountdown = state.countdown;
    }
}
