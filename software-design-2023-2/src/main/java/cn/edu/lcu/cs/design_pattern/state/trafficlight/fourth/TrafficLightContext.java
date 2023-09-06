package cn.edu.lcu.cs.design_pattern.state.trafficlight.fourth;

/**
 * <li>环境类，持有状态对象（交通灯），状态转换由状态对象自身负责</li>
 * <li>若扩展新的状态子类，环境类不需修改，符合开闭原则</li>
 * <li>状态转换时，需要状态子类对象修改环境类中的状态对象</li>
 * <li>所以环境类需要传递自身给状态子类，方便子类修改其属性</li>
 */

public class TrafficLightContext {
    private TrafficLight trafficLight;

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public TrafficLight.Color getColor() {
        return trafficLight.getColor();
    }

    public TrafficLightContext(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public TrafficLightContext() {
        trafficLight = new YellowLight();
    }

    public void change() {
        trafficLight.change(this);
    }
}
