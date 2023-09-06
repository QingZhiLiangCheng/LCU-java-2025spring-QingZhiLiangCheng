package cn.edu.lcu.cs.design_pattern.state.trafficlight.observable;

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
     * 控制台输出时的背景色
     */
    protected String bgColor;

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
        // \b 是退格键的意思，删除前边的一个字符
        // bgcolor 是一个字符转义序列，设置控制台文本的背景色
        System.out.print("\b\b\b\b" + bgColor + color + "  ");

        // 退2格，删除原来显示的秒数，并显示新秒数，占用2个显示位置
        // 修改倒计时
        System.out.printf("\b\b%02d", countdown);
    }

    /**
     * 状态迁移。后继状态由各状态子类负责。
     */
    public abstract void transition();
}
