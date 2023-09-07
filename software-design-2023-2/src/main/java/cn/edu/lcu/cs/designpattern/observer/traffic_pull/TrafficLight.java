package cn.edu.lcu.cs.designpattern.observer.traffic_pull;

import java.util.ArrayList;
import java.util.List;

import static cn.edu.lcu.cs.designpattern.observer.traffic_pull.TrafficLight.TrafficState.*;

/**
 * 交通信号灯状态转换示例
 */
public class TrafficLight implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private TrafficState state = TrafficState.YELLOW;

    public TrafficState getState() {
        return state;
    }

    /**
     * 改变状态
     */
    private void transition() {
        // 下个状态取决于当前状态
        switch (state) {
            case YELLOW:
                state = RED;
                break;
            case RED:
                state = GREEN;
                break;
            case GREEN:
                state = YELLOW;
                break;
        }
    }

    /**
     * 显示当前状态。
     */
    private void show() {
        System.out.println("当前状态：\t" + state);
    }

    public void start() {
        while (true) {
            // 改变状态
            transition();
            // 显示当前状态
            show();
            // 通知观察者
            notifyObservers();
            // 休眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.response(this));
    }

    @Override
    public void register(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        if (observer != null && observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    /**
     * 内部枚举类型
     */
    public enum TrafficState {
        YELLOW, RED, GREEN
    }
}
