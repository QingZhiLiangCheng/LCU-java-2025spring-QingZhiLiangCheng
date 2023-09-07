package cn.edu.lcu.cs.designpattern.state.trafficlight.third;


public abstract class TrafficLight {
    private String color;

    public TrafficLight(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    /**
     * <p>各状态子类负责转换状态，它们最清楚转换的算法</p>
     * <p>转换结束，需要修改环境类中的属性</p>
     * <p>但是转换算法被分散到各个子类，不方便集中管理</p>
     * @param context
     */
    public abstract void change(TrafficLightContext context);

}
