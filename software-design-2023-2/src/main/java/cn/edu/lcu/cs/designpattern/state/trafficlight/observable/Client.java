package cn.edu.lcu.cs.designpattern.state.trafficlight.observable;

import java.util.Observer;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        Random random = new Random();

        // 开独立线程，每隔一段时间产生一个观察者，并加入到交通灯的观察者列表中。
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Observer observer = ObserverGenerator.generateObserver();
                    light.addObserver(observer);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        // 启动交通灯，持续不断的工作。
        // 同时，另外的线程持续产生新的观察者并注册。
        light.start();
    }
}
