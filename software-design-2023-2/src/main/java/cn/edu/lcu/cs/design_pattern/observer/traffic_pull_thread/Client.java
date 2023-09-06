package cn.edu.lcu.cs.design_pattern.observer.traffic_pull_thread;

import java.util.Random;

public class Client {

    private static TrafficLight light;

    public static void main(String[] args) {
        // TODO 未完，待续



        // 创建被观察者对象
        light = new TrafficLight();
        // 创建观察者对象
        Pedestrian pedestrian = new Pedestrian("张三");
        Ambulance ambulance = new Ambulance("鲁P12021");
        // 注册观察者对象到被观察者对象
        light.register(ambulance);
        light.register(pedestrian);

        // 被观察对象持续更新状态，持续通知观察者
        light.start();
    }

    /**
     * 随机生成观察者，并注册到被观察者对象中
     */
    private void buildObserverAndRegister() {
        int id;
        switch (id = new Random().nextInt() % 2) {
            case 0:
                light.register(new Pedestrian("" + id));
                break;
            case 1:
                light.register(new Ambulance("鲁P" + id));
                break;
        }
    }
}
