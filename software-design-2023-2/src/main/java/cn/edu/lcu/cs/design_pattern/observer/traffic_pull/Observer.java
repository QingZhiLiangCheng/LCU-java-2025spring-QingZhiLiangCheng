package cn.edu.lcu.cs.design_pattern.observer.traffic_pull;

/**
 * 观察者
 */
public interface Observer {
    /**
     * 响应新状态，做出某些动作。
     * 观察者从传递过来的被观察者中拉取所需的数据，可能会暴露本不该暴露的东西。
     * 比如调用light中方法，访问light中的数据。
     *
     * @param light 被观察的对象
     */
    void response(TrafficLight light);
}
