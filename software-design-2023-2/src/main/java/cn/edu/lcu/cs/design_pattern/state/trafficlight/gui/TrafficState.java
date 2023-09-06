package cn.edu.lcu.cs.design_pattern.state.trafficlight.gui;

public abstract class TrafficState {
    /**
     * 状态对象依托的交通灯对象，相当于环境类Context
     */
    protected TrafficLight light;

    /**
     * 灯的颜色
     */
    protected String color;
    /**
     * 当前倒计时秒数
     */
    protected int countdown;

    public TrafficState(String color) {
        this.color = color;
    }

    public TrafficState(String color, int countdown) {
        this.color = color;
        this.countdown = countdown;
    }

    public TrafficState(String color, int countdown, TrafficLight light) {
        this.light = light;
        this.color = color;
        this.countdown = countdown;
    }

    /**
     * 心跳计数。
     * 后续状态由各状态负责。
     *
     * @return 颜色状态是否发生了变化
     */
    public abstract boolean change();
}
