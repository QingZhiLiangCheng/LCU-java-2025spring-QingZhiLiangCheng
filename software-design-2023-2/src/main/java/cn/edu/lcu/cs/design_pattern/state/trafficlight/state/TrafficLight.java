package cn.edu.lcu.cs.design_pattern.state.trafficlight.state;

/**
 * 交通灯模拟类，持有状态对象，相当于策略模式中的环境类Context
 */
public class TrafficLight {
    private TrafficState state;

    public TrafficLight() {
        // 设置初始状态
        state = new RedState(this);
    }

    /**
     * 启动交通灯，无限循环更新状态。
     */
    public void start() {
        while (true) {
            // 1、休眠一秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 2、休眠一秒之后进行状态迁移
            transition();
        }
    }

    /**
     * 状态迁移
     */
    private void transition() {
        // 状态迁移的策略由状态子类负责
        state.transition();
    }

    public void setState(TrafficState state) {
        this.state = state;
    }
}
