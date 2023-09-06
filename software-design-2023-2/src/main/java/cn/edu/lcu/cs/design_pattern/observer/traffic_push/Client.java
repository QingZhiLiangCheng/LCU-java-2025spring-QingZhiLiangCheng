package cn.edu.lcu.cs.design_pattern.observer.traffic_push;

public class Client {
    public static void main(String[] args) {
        // 创建被观察者对象
        TrafficLight light = new TrafficLight();
        // 创建观察者对象
        Pedestrian pedestrian = new Pedestrian("张三");
        Ambulance ambulance = new Ambulance("鲁P12021");
        // 注册观察者对象到被观察者对象
        light.register(ambulance);
        light.register(pedestrian);

        // 被观察对象持续更新状态，持续通知观察者
        light.start();
    }
}
