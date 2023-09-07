package cn.edu.lcu.cs.designpattern.state.trafficlight.observable;

import java.util.Observable;

/**
 * 交通灯模拟类。
 * 持有状态对象，相当于策略模式中的环境类Context。
 * 它还是可观察对象。
 *
 */
public class TrafficLight extends Observable {
    private TrafficState state;

    public TrafficState getState() {
        return state;
    }

    public void setState(TrafficState state) {
        setChanged();
        this.state = state;
        // 通知观察者。观察者与被观察者应该分属不同的线程，各自独立运行。
        notifyObservers();
    }

    public TrafficLight() {
        // 设置初始状态
        state = new YellowState(this);
    }

    /**
     * 启动交通灯，无限循环更新状态。
     */
    public void start() {
        while (true) {
            // 1、休眠一秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 2、休眠一秒之后进行状态迁移
            transition();
        }
    }

    /**
     * 状态迁移
     */
    private void transition() {
        // 状态迁移的策略由状态子类负责
        state.transition();
    }
}
