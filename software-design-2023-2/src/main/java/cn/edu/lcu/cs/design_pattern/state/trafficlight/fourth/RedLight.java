package cn.edu.lcu.cs.design_pattern.state.trafficlight.fourth;

public class RedLight extends TrafficLight {
    public RedLight() {
        super(Color.RED);
    }

    @Override
    public void change(TrafficLightContext context) {
        context.setTrafficLight(new GreenLight());
    }
}
