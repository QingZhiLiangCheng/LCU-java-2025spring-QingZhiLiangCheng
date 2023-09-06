package cn.edu.lcu.cs.design_pattern.observer.theory2;

/**
 * 观察者接口
 */
public interface Observer {
    /**
     * <p>当观察到目标状态变化时作出的更新响应</p>
     *
     * @param observable 被观察到的对象
     */
    public void update(Observable observable);

    /**
     * <p>当观察到目标状态变化时作出的更新响应</p>
     *
     * @param observable 被观察到的对象
     * @param state      传递过来的新状态
     */
    public void update(Observable observable, Object state);
}
