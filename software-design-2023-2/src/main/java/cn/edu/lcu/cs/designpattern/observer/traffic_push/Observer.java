package cn.edu.lcu.cs.designpattern.observer.traffic_push;

/**
 * 观察者
 */
public interface Observer {
    /**
     * 响应新状态，做出某些动作。
     *
     * @param state 被观察对象的新状态
     */
    void response(TrafficLight.TrafficState state);
}
