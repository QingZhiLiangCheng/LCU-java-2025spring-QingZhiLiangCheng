package cn.edu.lcu.cs.designpattern.state.trafficlight.state;

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
     * 显示
     */
    public void display() {
        System.out.println(color + "\t" + countdown);
    }

    /**
     * 状态迁移。后继状态由各状态子类负责。
     */
    public abstract void transition();
}
