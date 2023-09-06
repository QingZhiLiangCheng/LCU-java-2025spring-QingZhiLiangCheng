package cn.edu.lcu.cs.design_pattern.state.trafficlight.gui;

public class RedState extends TrafficState {
    public RedState(TrafficLight light) {
        super("红色", 30, light);
    }

    @Override
    public boolean change() {
        countdown--; // 心跳计数
        if (countdown==0) {
            // 改变状态，红灯的后续状态为绿灯
            light.setState(new GreenState(light));
            return true;
        }
        return false;
    }
}
