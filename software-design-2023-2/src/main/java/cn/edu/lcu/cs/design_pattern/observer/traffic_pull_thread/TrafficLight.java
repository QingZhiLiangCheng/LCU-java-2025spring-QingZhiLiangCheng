package cn.edu.lcu.cs.design_pattern.observer.traffic_pull_thread;

import java.util.ArrayList;
import java.util.List;

import static cn.edu.lcu.cs.design_pattern.observer.traffic_pull_thread.TrafficLight.TrafficState.*;

/**
 * 交通信号灯状态转换示例
 */
public class TrafficLight implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private TrafficState state = YELLOW;

    public TrafficState getState() {
        return state;
    }

    /**
     * 改变状态
     */
    private void change() {
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
            change(); // 改变状态
            show(); // 显示当前状态
            notifyObservers(); // 通知观察者
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
