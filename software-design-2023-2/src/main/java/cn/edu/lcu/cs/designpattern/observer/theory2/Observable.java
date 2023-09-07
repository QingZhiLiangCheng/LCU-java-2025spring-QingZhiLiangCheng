package cn.edu.lcu.cs.designpattern.observer.theory2;

import java.util.ArrayList;
import java.util.List;

/**
 * 可被观察的对象
 */
public abstract class Observable {
    private Object state;
    /**
     * 观察本主题的所有观察者
     */
    protected List<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }

    /**
     * <p>注册新观察者</p>
     *
     * @param observer
     */
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * <p>取消注册</p>
     *
     * @param observer
     */
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    /**
     * <p>通知所有的观察者</p>
     */
    public void notifyObservers() {
//        observers.forEach(observer -> observer.update(this));
        notifyObservers(state); // 把本身的状态作为参数通知给注册的观察者
    }


    /**
     * <p>通知所有的观察者，并传递参数</p>
     *
     * @param state 传递的参数
     */
    public void notifyObservers(Object state) {
        observers.forEach(observer -> observer.update(this, state));
    }


    public Object getState() {
        return state;
    }

    /**
     * 状态变量时，自动通知所有注册的观察者
     *
     * @param state
     */
    public void setState(Object state) {
        this.state = state;
        notifyObservers();
    }
}
