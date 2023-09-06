package cn.edu.lcu.cs.design_pattern.state.trafficlight.second;

/**
 * 环境类，持有状态（交通灯），并负责状态转换
 */
public class TrafficLightContext {
    private TrafficLight trafficLight;

    public String getColor() {
        return trafficLight.getColor();
    }

    public TrafficLightContext() {
        // 初始状态为黄灯
        trafficLight = new YellowLight();
    }

    /**
     * <li>改变状态</li>
     * <li>若增加新状态子类，本方法需要修改，添加新的条件分支，不符合开闭原则</li>
     * <li>但是，交通灯实例的需求非常确定，不会添加新状态子类</li>
     * <li>所以状态改变的算法放在此更方便集中管理</li>
     */
    public void change() {
        switch (trafficLight.getColor()) {
            case "红灯":
                trafficLight = new GreenLight();
                break;
            case "黄灯":
                trafficLight = new RedLight();
                break;
            case "绿灯":
                trafficLight = new YellowLight();
                break;
        }
    }
}
