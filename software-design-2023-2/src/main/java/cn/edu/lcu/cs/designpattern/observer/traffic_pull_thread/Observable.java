package cn.edu.lcu.cs.designpattern.observer.traffic_pull_thread;

/**
 * 能够被观察的
 */
public interface Observable {
    /**
     * 当被观察对象状态变化后，通知所有（或部分）观察者
     */
    void notifyObservers();

    /**
     * 观察者登录注册
     *
     * @param observer
     */
    void register(Observer observer);

    /**
     * 观察者取消登记注册
     *
     * @param observer
     */
    void unregister(Observer observer);

}
