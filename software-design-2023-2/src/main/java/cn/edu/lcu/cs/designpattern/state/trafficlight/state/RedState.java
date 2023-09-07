package cn.edu.lcu.cs.designpattern.state.trafficlight.state;

public class RedState extends TrafficState {
    public RedState(TrafficLight light) {
        super("红色", 30, light);
    }

    @Override
    public void transition() {
        // 显示当前状态
        display();
        // 心跳计数
        countdown--;
        if (countdown==0) {
            // 创建后继状态对象，并赋值给环境对象light
            // 本例的状态迁移逻辑简单，后继状态固定。
            // 如果系统比较复杂，后继状态的选择可能会有复杂的逻辑判断。
            light.setState(new GreenState(light));
        }
     }
}
