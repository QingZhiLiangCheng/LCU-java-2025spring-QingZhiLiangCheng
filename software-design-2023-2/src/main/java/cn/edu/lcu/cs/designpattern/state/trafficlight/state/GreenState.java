package cn.edu.lcu.cs.designpattern.state.trafficlight.state;

public class GreenState extends TrafficState {
    public GreenState(TrafficLight light) {
        super("绿色", 30, light);
    }

    @Override
    public void transition() {
        // 打印当前状态
        display();
        // 修改倒计时
        countdown--;
        if (countdown==0) {
            // 如果倒计时时间到，设置后继状态
            light.setState(new YellowState(light));
        }
     }
}
